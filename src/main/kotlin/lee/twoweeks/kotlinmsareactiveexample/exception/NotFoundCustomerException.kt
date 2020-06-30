package lee.twoweeks.kotlinmsareactiveexample.exception

import org.bson.types.ObjectId

class NotFoundCustomerException : RuntimeException {
    constructor(id: String) : super("The customer with id[${id}] is not found.")
}