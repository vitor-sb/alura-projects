package vitorsb.alura.forum.entity

import vitorsb.alura.forum.commons.Audit
import vitorsb.alura.forum.commons.interfaces.Auditable
import vitorsb.alura.forum.commons.interfaces.Identifiable
import java.io.Serializable
import javax.persistence.*

@Entity
data class Answer(
    @Id
    @Column(nullable = false, length = 36)
    override val id: String,

    @Column(nullable = false, length = 500)
    val message: String,

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    val topic: Topic,

    @JoinColumn(nullable = true)
    val isSolution: Boolean? = null

) : Auditable, Identifiable<String>, Serializable {
    @Embedded
    override var audit: Audit = Audit()
}