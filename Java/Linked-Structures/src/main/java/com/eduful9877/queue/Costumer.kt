package com.eduful9877.queue

data class Costumer(
    val id: Int,
    val firstName: String,
    val secondName: String
) : CustomerJ(id, firstName, secondName) {

    fun getCustomerNameById(): Int {
        return getId()
    }
}
