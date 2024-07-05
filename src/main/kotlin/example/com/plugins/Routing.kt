package example.com.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.request.receive
import example.com.collection.FragranceCollection
import example.com.dto.FragranceDto
import example.com.extension.toDto
import example.com.extension.toFragrance
import io.ktor.http.*
import org.bson.types.ObjectId

fun Application.configureRouting() {
    val fragranceCollection = FragranceCollection()
    routing {
        get("/") {
            val fragrances = fragranceCollection.getAllFragrances().map { it.toDto() }

            call.respond(fragrances)
        }

        post("/") {
            val fragrance = call.receive<FragranceDto>().toFragrance()

            fragranceCollection.addFragrance(fragrance)
            call.respond(HttpStatusCode.Created, fragrance.toDto())
        }

        put("/") {
            val id = call.parameters["id"] ?: return@put call.respond(HttpStatusCode.BadRequest)
            val fragrance = call.receive<FragranceDto>().toFragrance()

            fragranceCollection.updateFragrance(ObjectId(id), fragrance)
            call.respond(HttpStatusCode.OK, fragrance.toDto())
        }

        delete("/") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)

            fragranceCollection.deleteFragrance(ObjectId(id))
            call.respond(HttpStatusCode.OK)
        }
    }
}
