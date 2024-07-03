package example.com.model

import java.time.LocalDate

data class Fragrance (
    var id: String, // Unique identifier for the fragrance
    var name: String,
    var description: String,
    var category: String,
    var created_at: LocalDate,
    var updated_at: LocalDate,
    var image_url: String
)