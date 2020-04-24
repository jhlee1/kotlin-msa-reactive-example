package lee.twoweeks.kotlinmsareactiveexample.service

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import lee.twoweeks.kotlinmsareactiveexample.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */


@Service
class CustomerReactiveMongoServiceImpl : CustomerReactiveMongoService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int): Mono<Customer> = customerRepository.findById(id)
    override fun createCustomer(customer: Mono<Customer>): Mono<Customer> = customerRepository.create(customer)
    override fun deleteCustomer(id: Int): Mono<Boolean> = customerRepository.deleteById(id).map { it.deletedCount > 0 }
    override fun searchCustomers(nameFilter: String): Flux<Customer> = customerRepository.findCustomer(nameFilter)
}