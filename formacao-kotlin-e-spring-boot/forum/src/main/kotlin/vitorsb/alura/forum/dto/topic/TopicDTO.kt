package vitorsb.alura.forum.dto.topic

import vitorsb.alura.forum.model.enums.TopicStatus

data class TopicDTO(
    val id: String?,
    val title: String,
    val message: String,
    val status: TopicStatus,
)