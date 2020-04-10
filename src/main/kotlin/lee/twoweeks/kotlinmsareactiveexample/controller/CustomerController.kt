package lee.twoweeks.kotlinmsareactiveexample.controller

import lee.twoweeks.kotlinmsareactiveexample.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) : ResponseEntity<Customer> {
        return ResponseEntity(Customer(id, "customer $id"), HttpStatus.OK)
    }
}