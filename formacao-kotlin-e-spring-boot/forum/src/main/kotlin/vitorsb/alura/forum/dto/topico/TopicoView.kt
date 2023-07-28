package vitorsb.alura.forum.dto.topico

import vitorsb.alura.forum.model.enums.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
    val id: String?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
) {

}
