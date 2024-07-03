package example.com.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.litote.kmongo.KMongo
import com.mongodb.client.MongoClient

fun Application.configureMongo() {
    MongoDatabase().getDatabase()
}

class MongoDatabase() {
    fun getDatabase() = KMongo.createClient("mongodb+srv://<user>:<pass>@fragrances.lo8xbsy.mongodb.net/").getDatabase("monday")   
}