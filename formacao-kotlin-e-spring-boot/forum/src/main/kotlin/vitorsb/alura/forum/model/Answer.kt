package vitorsb.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer(
    @Id
    @Column(nullable = false, length = 36)
    val id: String,
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