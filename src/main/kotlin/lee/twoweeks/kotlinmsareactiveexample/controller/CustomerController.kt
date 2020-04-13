package lee.twoweeks.kotlinmsareactiveexample.controller

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import lee.twoweeks.kotlinmsareactiveexample.service.CustomerService
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) : ResponseEntity<Mono<Customer>> {

// Mono 만들기
//        val customerMono : Mono<Customer> = Mono.just(Customer(1, "Mono"));
//        val customerMono = Mono.just(Customer(1, "Mono"));
//        val customerMono = Customer(1, "Mono").toMono();
        return ResponseEntity(customerService.getCustomer(id), HttpStatus.OK)
    }

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) = customerService.searchCustomers(nameFilter);

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customerMono: Mono<Customer>) = ResponseEntity(customerService.createCustomer(customerMono), HttpStatus.CREATED)
}