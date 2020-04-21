package lee.twoweeks.kotlinmsareactiveexample.model

import org.springframework.data.mongodb.core.mapping.Document

@Document("Customers")
data class Customer(var id: Int = 0, val name: String = "", val telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}
