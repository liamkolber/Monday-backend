package example.com.plugins

import io.ktor.server.application.*
import org.litote.kmongo.KMongo

fun Application.configureMongo() {
    MongoDatabase().getDatabase()
}

class MongoDatabase() {
    fun getDatabase() = KMongo.createClient(System.getenv("MONGODB_DATABASE_URL")).getDatabase("monday")
}