package lee.twoweeks.kotlinmsareactiveexample.router

import lee.twoweeks.kotlinmsareactiveexample.handler.CustomerHandler
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router

/**
 * Created by Joohan Lee on 2020/04/13
 *
 */

@Component
class CustomerRouter(private val customerHandler: CustomerHandler) {
    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/customer".nest {
                GET("/{id}", customerHandler::get)
                POST("/", customerHandler::create)
            }

            "customers".nest {
                GET("/", customerHandler::search)
            }
        }
    }
}