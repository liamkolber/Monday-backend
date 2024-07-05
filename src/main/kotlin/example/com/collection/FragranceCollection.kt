package example.com.collection

import example.com.plugins.MongoDatabase
import example.com.model.Fragrance
import org.litote.kmongo.getCollection

class FragranceCollection() {
    val collection = MongoDatabase().getDatabase().getCollection<Fragrance>("fragrances")

    fun getAllFragrances() = collection.find().toList()

    fun addFragrance(fragrance: Fragrance) = collection.insertOne(fragrance)

    //update

    //delete
}

