package pl.stepwise.user

import java.util.*

data class UserDto(
    val id: String = UUID.randomUUID().toString(),
    val firstName: String = "FirstName",
    val lastName: String = "LastName"
)