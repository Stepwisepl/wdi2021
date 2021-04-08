package pl.stepwise.springdemo.user

import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer
import org.springframework.boot.autoconfigure.mongo.MongoPropertiesClientSettingsBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import pl.stepwise.user.UserHandler

@Configuration
class UserRouter {

    @Bean
    fun createUserRoute(userHandler: UserHandler): RouterFunction<ServerResponse> =
        RouterFunctions.route(RequestPredicates.POST("/users")) { userHandler.createUser() }

    @Bean
    fun userHandler(mongoClient: MongoClient) = UserHandler(mongoClient)

    @Bean
    fun mongoCustomizer() =  MongoClientSettingsBuilderCustomizer { builder->
        val pojoCodecRegistry: CodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        )

        builder
            .codecRegistry(pojoCodecRegistry)
    }
}