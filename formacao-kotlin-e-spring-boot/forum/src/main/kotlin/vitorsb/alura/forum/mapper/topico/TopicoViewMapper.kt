package vitorsb.alura.forum.mapper.topico

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topico.TopicoView
import vitorsb.alura.forum.mapper.GenericMapper
import vitorsb.alura.forum.model.Topico

@Component
class TopicoViewMapper: GenericMapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status)
    }
}