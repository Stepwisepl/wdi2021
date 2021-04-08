package pl.stepwise.user

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class UserDto(
    val id: String = UUID.randomUUID().toString(),
    val firstName: String = "FirstName",
    val lastName: String = "LastName"
)