package lee.twoweeks.kotlinmsareactiveexample.handler

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import lee.twoweeks.kotlinmsareactiveexample.service.CustomerReactiveMongoService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import java.net.URI

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Component
class MongoCustomerHandler(val customerReactiveMongoService: CustomerReactiveMongoService) {
    fun get(serverRequest: ServerRequest) = customerReactiveMongoService.getCustomer(serverRequest.pathVariable("id").toInt())
            .flatMap { ok().body(fromValue(it)) }
            .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())

    fun create(serverRequest: ServerRequest) = customerReactiveMongoService.createCustomer(serverRequest.bodyToMono())
            .flatMap { created(URI.create("/customer/${it.id}")).build() }

    fun delete(serverRequest: ServerRequest) = customerReactiveMongoService.deleteCustomer(serverRequest.pathVariable("id").toInt())
            .flatMap {
                if (it) ok().build()
                else status(HttpStatus.NOT_FOUND).build()
            }

    fun search(serverRequest: ServerRequest) = ok()
            .body(
                    customerReactiveMongoService.searchCustomers(
                            serverRequest.queryParam("nameFilter")
                                    .orElse("")),
                    Customer::class.java
            )
}