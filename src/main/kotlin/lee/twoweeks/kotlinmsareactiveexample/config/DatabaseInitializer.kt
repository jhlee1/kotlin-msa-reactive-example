package lee.twoweeks.kotlinmsareactiveexample.config

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import lee.twoweeks.kotlinmsareactiveexample.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Component
class DatabaseInitializer {
    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations
    @Autowired
    lateinit var customerRepository: CustomerRepository

    @PostConstruct // This method is called after its component is created
    fun initData() {
        mongoOperations.collectionExists("Customers").subscribe {
            if (!it) {
                mongoOperations.createCollection("Customers").subscribe {
                    println("Customers collections created")
                }
            } else println("Customer collection already exists.")
        }
    }
}