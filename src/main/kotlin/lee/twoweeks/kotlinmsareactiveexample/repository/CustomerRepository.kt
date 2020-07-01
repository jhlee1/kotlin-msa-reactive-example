package lee.twoweeks.kotlinmsareactiveexample.repository

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

//interface CustomerRepository : ReactiveCrudRepository<Customer, Int>

@Repository
interface CustomerRepository : ReactiveMongoRepository<Customer, ObjectId>, CustomerRepositoryCustom{
//    fun create(customer: Mono<Customer>) = template.save(customer)
//    fun findById(id : Int) = template.findById<Customer>(id)
//    fun deleteById(id: Int) = template.remove(<Customer>(Query(where("_id").isEqualTo(id)))

}