package vitorsb.alura.forum.model

import java.util.*

data class User(
    val id: String? = UUID.randomUUID().toString(),
    val name: String,
    val email: String
)