package lee.twoweeks.kotlinmsareactiveexample.service

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import reactor.core.publisher.Mono

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

interface CustomerReactiveMongoService {
    fun getCustomer(id: Int) : Mono<Customer>
}