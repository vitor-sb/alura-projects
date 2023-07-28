package vitorsb.alura.forum.model

import java.util.*

data class Usuario(
    val id: String? = UUID.randomUUID().toString(),
    val nome: String,
    val email: String
) {
}