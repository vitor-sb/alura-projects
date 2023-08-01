package vitorsb.alura.forum.model

import vitorsb.alura.forum.model.commons.Audit
import vitorsb.alura.forum.model.commons.interfaces.Auditable
import vitorsb.alura.forum.model.commons.interfaces.Identifiable
import vitorsb.alura.forum.model.enums.TopicStatus
import java.io.Serializable
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
data class Topic(
    @Id
    @Column(nullable = false, length = 36)
    override var id: String,

    val title: String,

    val message: String,

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    val course: Course,

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,

    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NAO_RESPONDIDO,

    @OneToMany(mappedBy = "topic")
    val replies: List<Answer> = ArrayList()

) : Auditable, Identifiable<String>, Serializable {
    @Embedded
    override var audit: Audit = Audit()
}
