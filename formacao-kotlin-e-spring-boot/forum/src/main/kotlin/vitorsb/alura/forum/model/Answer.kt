package vitorsb.alura.forum.model

import vitorsb.alura.forum.model.commons.Audit
import vitorsb.alura.forum.model.commons.interfaces.Auditable
import vitorsb.alura.forum.model.commons.interfaces.Identifiable
import java.io.Serializable
import javax.persistence.*

@Entity
data class Answer(
    @Id
    @Column(nullable = false, length = 36)
    override val id: String,

    val message: String,

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    val topic: Topic,

    val isSolution: Boolean

): Auditable, Identifiable<String>, Serializable {
    @Embedded
    override var audit: Audit = Audit()
}