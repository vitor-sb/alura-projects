package vitorsb.alura.forum.mapper.topico

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topico.NovoTopicoForm
import vitorsb.alura.forum.model.Curso
import vitorsb.alura.forum.model.Topico
import vitorsb.alura.forum.model.Usuario
import java.util.*

@Component
class NovoTopicoFormMapper {

    fun map(t: NovoTopicoForm, curso: Curso, autor: Usuario): Topico {
        return Topico(
            id = UUID.randomUUID().toString(),
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = curso,
            autor = autor
        )
    }

}
