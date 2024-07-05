package example.com.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.request.receive
import example.com.collection.FragranceCollection
import example.com.model.Fragrance
import example.com.dto.FragranceDto
import example.com.extension.toFragrance

fun Application.configureRouting() {
    val fragranceCollection = FragranceCollection()
    routing {
        get("/") {
            val fragrances = fragranceCollection.getAllFragrances()
            println("\nGETTING ALL FRAGRANCES:\n" + fragrances + "\n")
            call.respond(fragrances)
        }

        post("/") {
            val fragrance = call.receive<FragranceDto>().toFragrance()
            println("\nADDING A FRAGRANCE:\n")
            fragranceCollection.addFragrance(fragrance)
        }

        //update

        //delete
    }
}
