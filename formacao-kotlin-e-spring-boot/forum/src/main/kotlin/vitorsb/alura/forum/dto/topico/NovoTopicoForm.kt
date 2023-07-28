package vitorsb.alura.forum.dto.topico

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 80)
    val titulo: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 255)
    val mensagem: String,

    @field:NotNull
    val idCurso: String,

    @field:NotNull
    val idAutor: String,
) {
}