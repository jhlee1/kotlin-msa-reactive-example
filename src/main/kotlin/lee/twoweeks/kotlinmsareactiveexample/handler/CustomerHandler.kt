package lee.twoweeks.kotlinmsareactiveexample.handler

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import lee.twoweeks.kotlinmsareactiveexample.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import java.net.URI

/**
 * Created by Joohan Lee on 2020/04/13
 *
 */

@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) : Mono<ServerResponse> =
            ok().body(customerService.getCustomer(serverRequest.pathVariable("id").toInt())
                    .flatMap { ok().body(fromValue(it)) }
                    .switchIfEmpty(notFound().build()))

    fun search(serverRequest: ServerRequest) = ok()
            .body(
                    customerService.searchCustomers(
                            serverRequest.queryParam("nameFilter")
                                    .orElse("")),
                    Customer::class.java
            )
    fun create(serverRequest: ServerRequest) =
            customerService.createCustomer(serverRequest.bodyToMono())
                    .flatMap { created(URI.create("/functional/customer/${it.id}")).build() }
}

