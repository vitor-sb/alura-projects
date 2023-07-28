package vitorsb.alura.forum.model

import java.util.*

data class Curso(
    val id: String? = UUID.randomUUID().toString(),
    val nome: String,
    val categoria: String
) {
}