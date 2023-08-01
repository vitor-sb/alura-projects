package vitorsb.alura.forum.model

import vitorsb.alura.forum.model.commons.Audit
import vitorsb.alura.forum.model.commons.interfaces.Auditable
import vitorsb.alura.forum.model.commons.interfaces.Identifiable
import java.io.Serializable
import javax.persistence.*

@Entity
data class User(
    @Id
    @Column(nullable = false, length = 36)
    override val id: String,

    val name: String,

    val email: String

): Auditable, Identifiable<String>, Serializable {
    @Embedded
    override var audit: Audit = Audit()
}