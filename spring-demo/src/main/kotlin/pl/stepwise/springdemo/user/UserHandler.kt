package pl.stepwise.user

import com.mongodb.reactivestreams.client.MongoClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

class UserHandler(
    @Autowired private val mongoClient: MongoClient
) {
    private val mongoDatabase = mongoClient.getDatabase("micronaut")
    private val userCollection = mongoDatabase.getCollection("user", UserDto::class.java)


    @PostMapping
    fun createUser(): Mono<ServerResponse> {
        val userDto = UserDto()
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromPublisher(userCollection.insertOne(userDto).toMono().map { userDto }, ParameterizedTypeReference.forType(UserDto::class.java)))
    }
}