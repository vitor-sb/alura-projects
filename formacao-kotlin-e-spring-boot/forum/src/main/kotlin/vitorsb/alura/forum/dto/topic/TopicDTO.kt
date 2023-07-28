package vitorsb.alura.forum.dto.topic

import vitorsb.alura.forum.model.enums.TopicStatus
import java.time.LocalDateTime

data class TopicDTO(
    val id: String?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val creationDate: LocalDateTime
)