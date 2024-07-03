package example.com.collection

import example.com.plugins.MongoDatabase
import example.com.model.Fragrance

class FragranceCollection() {
    val collection = MongoDatabase().getDatabase().getCollection("fragrance")

    fun getAllFragrances(): List<Fragrance> = emptyList()
}

