package lee.twoweeks.kotlinmsareactiveexample.service

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring", Customer.Telephone("+44", "7123456789")),
                Customer(3, "Microservice", Customer.Telephone("+44", "7123456789"))
        )
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = Mono.justOrEmpty(customers[id]);

    override fun searchCustomers(nameFilter: String): List<Customer> {
        return customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toList();
    }

}