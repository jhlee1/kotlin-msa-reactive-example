package lee.twoweeks.kotlinmsareactiveexample.repository

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import reactor.core.publisher.Flux

interface CustomerRepositoryCustom {
    fun findCustomer(nameFilter: String): Flux<Customer>
}