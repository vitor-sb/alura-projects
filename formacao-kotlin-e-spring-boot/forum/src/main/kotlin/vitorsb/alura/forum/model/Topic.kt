package vitorsb.alura.forum.model

import vitorsb.alura.forum.model.enums.TopicStatus
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

data class Topic(
    var id: String? = UUID.randomUUID().toString(),
    val title: String,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NAO_RESPONDIDO,
    val replies: List<Reply> = ArrayList()
)
