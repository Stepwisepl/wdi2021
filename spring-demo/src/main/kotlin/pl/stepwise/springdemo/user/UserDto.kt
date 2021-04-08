package pl.stepwise.user

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class UserDto(
    val id: String = UUID.randomUUID().toString(),
    val firstName: String = "FirstName_",
    val lastName: String = "LastName_"
) 