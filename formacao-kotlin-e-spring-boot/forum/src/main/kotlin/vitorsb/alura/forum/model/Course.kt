package vitorsb.alura.forum.model

import java.util.*

data class Course(
    val id: String? = UUID.randomUUID().toString(),
    val name: String,
    val category: String
)