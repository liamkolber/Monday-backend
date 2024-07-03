package example.com.model

import java.time.LocalDate
import org.bson.types.ObjectId
import org.bson.codecs.pojo.annotations.BsonId

data class Fragrance (
    @BsonId
    var id: ObjectId? = null,
    
    var fragranceId: String,
    var name: String,
    var description: String,
    var category: String,
    var created_at: String,
    var updated_at: String,
    var image_url: String
)