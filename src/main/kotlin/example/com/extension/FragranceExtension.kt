package example.com.extension

import example.com.model.Fragrance
import example.com.dto.FragranceDto
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


fun Fragrance.toDto() = FragranceDto(
    id = this.id.toString(),
    fragranceId = this.fragranceId,
    name = this.name,
    description = this.description,
    category = this.category,
    created_at = this.created_at,
    updated_at = this.updated_at,
    image_url = this.image_url
)

fun FragranceDto.toFragrance() = Fragrance(
    id = if(this.id == null) {null} else {ObjectId(this.id)},
    fragranceId = this.fragranceId ?: Random.nextInt(10000, 99999).toString(),
    name = this.name,
    description = this.description,
    category = this.category,
    created_at = this.created_at ?: LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    updated_at = this.updated_at ?: LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    image_url = this.image_url
)