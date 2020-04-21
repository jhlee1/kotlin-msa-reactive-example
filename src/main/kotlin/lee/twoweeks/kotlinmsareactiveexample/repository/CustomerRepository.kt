package lee.twoweeks.kotlinmsareactiveexample.repository

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import javax.annotation.PostConstruct

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

//interface CustomerRepository : ReactiveCrudRepository<Customer, Int>

@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val initialCustomers = listOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservice", Customer.Telephone("+44", "7123456789"))
        )

    }

    @PostConstruct
    fun initializeRepository() = initialCustomers.map(Customer::toMono)
            .map(this::create)
            .map(Mono<Customer>::subscribe)


    fun create(customer: Mono<Customer>) = template.save(customer)
    fun findById(id : Int) = template.findById<Customer>(id)
}