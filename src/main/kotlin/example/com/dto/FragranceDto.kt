package example.com.dto

import kotlinx.serialization.*

@Serializable
data class FragranceDto (
    var id: String? = null,
    var fragranceId: String,
    var name: String,
    var description: String,
    var category: String,
    var created_at: String,
    var updated_at: String,
    var image_url: String
)