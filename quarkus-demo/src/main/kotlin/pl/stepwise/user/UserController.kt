package pl.stepwise.user

import io.quarkus.mongodb.reactive.ReactiveMongoClient
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/users")
class UserController() {

    @Inject
    private lateinit var mongoClient: ReactiveMongoClient
    private val mongoDatabase by lazy { mongoClient.getDatabase("micronaut") }
    private val userCollection by lazy { mongoDatabase.getCollection("user", UserDto::class.java) }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun createUser(): Uni<UserDto> {
        val userDto = UserDto()
        return userCollection.insertOne(userDto)
            .map { userDto }
    }
}