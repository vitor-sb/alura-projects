package vitorsb.alura.forum.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String? = UUID.randomUUID().toString(),
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    val topic: Topic,
    val isSolution: Boolean
)