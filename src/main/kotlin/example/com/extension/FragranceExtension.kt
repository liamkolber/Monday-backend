package example.com.extension

import example.com.model.Fragrance
import example.com.dto.FragranceDto
import org.bson.types.ObjectId


fun Fragrance.toDto() = FragranceDto(
    mongoID = this.id.toString(),
    id = this.fragranceId,
    name = this.name,
    description = this.description,
    category = this.category,
    created_at = this.created_at,
    updated_at = this.updated_at,
    image_url = this.image_url
)

fun FragranceDto.toFragrance() = Fragrance(
    id = ObjectId(this.mongoID),
    fragranceId = this.id,
    name = this.name,
    description = this.description,
    category = this.category,
    created_at = this.created_at,
    updated_at = this.updated_at,
    image_url = this.image_url
)