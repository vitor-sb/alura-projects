package vitorsb.alura.forum.model

import vitorsb.alura.forum.model.enums.StatusTopico
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

data class Topico(
    var id: String? = UUID.randomUUID().toString(),
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
){

}