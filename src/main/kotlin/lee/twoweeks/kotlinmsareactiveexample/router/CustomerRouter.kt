package lee.twoweeks.kotlinmsareactiveexample.router

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.kotlin.core.publisher.toMono

/**
 * Created by Joohan Lee on 2020/04/13
 *
 */

@Component
class CustomerRouter {
    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/customer".nest {
                GET("/") {
                    ServerResponse.ok().body(Customer(1, "functional web").toMono(), Customer::class.java)
                }
            }
        }
    }
}