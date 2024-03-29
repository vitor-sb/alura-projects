package vitorsb.alura.forum.entity

import vitorsb.alura.forum.commons.Audit
import vitorsb.alura.forum.commons.interfaces.Auditable
import vitorsb.alura.forum.commons.interfaces.Identifiable
import vitorsb.alura.forum.entity.enums.TopicStatus
import java.io.Serializable
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
data class Topic(
    @Id
    @Column(nullable = false, length = 36)
    override var id: String,

    @Column(nullable = false, length = 125)
    val title: String,

    @Column(nullable = false, length = 500)
    val message: String,

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    val course: Course,

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 32)
    val status: TopicStatus = TopicStatus.NAO_RESPONDIDO,

    @OneToMany(mappedBy = "topic")
    val replies: List<Answer> = ArrayList()

) : Auditable, Identifiable<String>, Serializable {
    @Embedded
    override var audit: Audit = Audit()
}
