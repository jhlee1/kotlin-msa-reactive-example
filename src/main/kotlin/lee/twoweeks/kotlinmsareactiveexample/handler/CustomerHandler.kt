package lee.twoweeks.kotlinmsareactiveexample.handler

import lee.twoweeks.kotlinmsareactiveexample.service.CustomerService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

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
}

