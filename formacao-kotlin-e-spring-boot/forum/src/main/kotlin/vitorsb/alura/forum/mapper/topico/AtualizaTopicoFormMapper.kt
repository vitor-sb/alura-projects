package vitorsb.alura.forum.mapper.topico

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topico.AtualizaTopicoForm
import vitorsb.alura.forum.model.Topico
import java.util.*

@Component
class AtualizaTopicoFormMapper {

    fun map(topicoSalvo: Topico, t: AtualizaTopicoForm): Topico {
        return Topico(
            id = UUID.randomUUID().toString(),
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = topicoSalvo.curso,
            autor = topicoSalvo.autor,
            respostas = topicoSalvo.respostas,
            status = topicoSalvo.status,
            dataCriacao = topicoSalvo.dataCriacao
        )
    }

}
