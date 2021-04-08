package pl.stepwise.user

import com.mongodb.reactivestreams.client.MongoClient
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.reactivex.Single
import javax.inject.Inject



// micronaut has its own annotations for REST stuff (like spring boot)
@Controller("/users")
class UserController(
    @Inject private val mongoClient: MongoClient
) {

    private val mongoDatabase = mongoClient.getDatabase("micronaut")
    private val userCollection = mongoDatabase.getCollection("user", UserDto::class.java)


    @Post
    fun createUser(): Single<UserDto> {
        val userDto = UserDto()
        return Single.fromPublisher(userCollection.insertOne(userDto))
            .map { userDto }
    }
}