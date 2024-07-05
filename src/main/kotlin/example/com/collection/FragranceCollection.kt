package example.com.collection

import com.mongodb.client.result.InsertOneResult
import example.com.plugins.MongoDatabase
import example.com.model.Fragrance
import org.bson.types.ObjectId
import org.litote.kmongo.deleteOneById
import org.litote.kmongo.getCollection
import org.litote.kmongo.replaceOneById

class FragranceCollection() {
    private val collection = MongoDatabase().getDatabase().getCollection<Fragrance>("fragrances")

    fun getAllFragrances() = collection.find().toList()

    fun addFragrance(fragrance: Fragrance): InsertOneResult = collection.insertOne(fragrance)

    fun updateFragrance(id: ObjectId, newFragrance: Fragrance) = collection.replaceOneById(id, newFragrance)

    fun deleteFragrance(id: ObjectId) = collection.deleteOneById(id)
}

