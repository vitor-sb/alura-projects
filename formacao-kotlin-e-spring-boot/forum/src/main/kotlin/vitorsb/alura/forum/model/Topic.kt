package vitorsb.alura.forum.model

import vitorsb.alura.forum.model.enums.TopicStatus
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String? = UUID.randomUUID().toString(),
    val title: String,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
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
)