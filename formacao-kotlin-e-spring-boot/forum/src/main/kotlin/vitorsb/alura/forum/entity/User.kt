package vitorsb.alura.forum.entity

import vitorsb.alura.forum.commons.Audit
import vitorsb.alura.forum.commons.interfaces.Auditable
import vitorsb.alura.forum.commons.interfaces.Identifiable
import java.io.Serializable
import javax.persistence.*

@Entity
data class User(
    @Id
    @Column(nullable = false, length = 36)
    override val id: String,

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(nullable = false, length = 160)
    val email: String

): Auditable, Identifiable<String>, Serializable {
    @Embedded
    override var audit: Audit = Audit()
}