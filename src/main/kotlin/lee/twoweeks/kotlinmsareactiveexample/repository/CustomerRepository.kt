package lee.twoweeks.kotlinmsareactiveexample.repository

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.data.mongodb.core.remove
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
interface CustomerRepository : ReactiveCrudRepository<Customer, ObjectId>, CustomerRepositoryCustom{
//    fun create(customer: Mono<Customer>) = template.save(customer)
//    fun findById(id : Int) = template.findById<Customer>(id)
//    fun deleteById(id: Int) = template.remove(<Customer>(Query(where("_id").isEqualTo(id)))

}