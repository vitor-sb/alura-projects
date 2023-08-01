package vitorsb.alura.forum.model

import javax.persistence.*

@Entity
data class Course(
    @Id
    @Column(nullable = false, length = 36)
    val id: String,
    val name: String,
    val category: String
)