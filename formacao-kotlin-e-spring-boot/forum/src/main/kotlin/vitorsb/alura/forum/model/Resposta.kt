package vitorsb.alura.forum.model

import java.time.LocalDateTime
import java.util.*

data class Resposta(
    val id: String? = UUID.randomUUID().toString(),
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val solucao: Boolean
) {
}