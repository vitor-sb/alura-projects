package vitorsb.alura.forum.repository

import vitorsb.alura.forum.dto.topico.TopicoView
import vitorsb.alura.forum.mapper.topico.TopicoViewMapper
import vitorsb.alura.forum.model.Topico

class TopicoRepository (
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
) {
    fun cadastrar(t: Topico): TopicoView {
        topicos = topicos.plus(t)
        return topicoViewMapper.map(t)
    }
}