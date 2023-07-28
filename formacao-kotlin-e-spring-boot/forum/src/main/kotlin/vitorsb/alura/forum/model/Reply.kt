package vitorsb.alura.forum.model

import java.time.LocalDateTime
import java.util.*

data class Reply(
    val id: String? = UUID.randomUUID().toString(),
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val isSolution: Boolean
)