package vitorsb.alura.forum.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String? = UUID.randomUUID().toString(),
    val name: String,
    val category: String
)