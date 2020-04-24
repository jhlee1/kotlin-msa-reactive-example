package lee.twoweeks.kotlinmsareactiveexample.router

import lee.twoweeks.kotlinmsareactiveexample.handler.MongoCustomerHandler
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Component
class MongoCustomerRouter(val mongoCustomerHandler: MongoCustomerHandler) {
    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/functionalMongo".nest {
            "/customer".nest {
                GET("/{id}", mongoCustomerHandler::get)
                POST("/", mongoCustomerHandler::create)
                DELETE("/{id}", mongoCustomerHandler::delete)
            }
            "/customers".nest {
                GET("/", mongoCustomerHandler::search)
            }
        }

    }

}
