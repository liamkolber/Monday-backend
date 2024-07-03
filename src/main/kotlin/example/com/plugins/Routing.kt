package example.com.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import example.com.collection.FragranceCollection

fun Application.configureRouting() {
    val fragranceCollection = FragranceCollection()
    routing {
        get("/") {
            println("\n" + fragranceCollection.getAllFragrances() + "\n")
            call.respond(fragranceCollection.getAllFragrances())
        }
    }
}
