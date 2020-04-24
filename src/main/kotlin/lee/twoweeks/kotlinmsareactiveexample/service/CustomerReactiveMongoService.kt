package lee.twoweeks.kotlinmsareactiveexample.service

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

interface CustomerReactiveMongoService {
    fun getCustomer(id: Int) : Mono<Customer>
    fun createCustomer(customer: Mono<Customer>) : Mono<Customer>
    fun deleteCustomer(id: Int) : Mono<Boolean>
    fun searchCustomers(nameFilter: String) : Flux<Customer>
}