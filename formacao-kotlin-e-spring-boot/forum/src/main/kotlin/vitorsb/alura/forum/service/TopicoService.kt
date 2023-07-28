package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import vitorsb.alura.forum.dto.topico.AtualizaTopicoForm
import vitorsb.alura.forum.dto.topico.NovoTopicoForm
import vitorsb.alura.forum.model.Topico
import vitorsb.alura.forum.dto.topico.TopicoView
import vitorsb.alura.forum.mapper.topico.AtualizaTopicoFormMapper
import vitorsb.alura.forum.mapper.topico.NovoTopicoFormMapper
import vitorsb.alura.forum.mapper.topico.TopicoViewMapper
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
    private val topicoViewMapper: TopicoViewMapper,
    private val novoTopicoFormMapper: NovoTopicoFormMapper,
    private val atualizaTopicoFormMapper: AtualizaTopicoFormMapper,
) {

    private val logger = LoggerFactory.getLogger(TopicoService::class.java)

    fun cadastrar(dto: NovoTopicoForm): TopicoView {
        logger.info("M=cadastrar:TopicoView - Cadastrando tópico")

        val curso = cursoService.buscarPorId(dto.idCurso)
        val autor = usuarioService.buscarPorId(dto.idAutor)
        val topico = novoTopicoFormMapper.map(dto, curso, autor)

        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizaTopicoForm): TopicoView {
        logger.info("M=atualizar:TopicoView - Atualizando tópico com id:${dto.id}")
        val topicoSalvo = topicos.stream().filter { t -> t.id == dto.id }.findFirst().get()

        val topicoAtualizado = atualizaTopicoFormMapper.map(topicoSalvo, dto)
        topicos = topicos.minus(topicoSalvo).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun listar(): List<TopicoView> {
        logger.info("M=listar:List<TopicoView> - Listando topicos existentes")
        return topicos.stream().map { t -> topicoViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: String): TopicoView {
        logger.info("M=buscarPorId:TopicoView - Buscando topico por id:${id}")
        val t = topicos.stream().filter { t -> t.id == id }.findFirst().get()
        return topicoViewMapper.map(t)
    }

    fun buscarTopicoPorId(id: String): Topico {
        logger.info("M=buscarPorId:Topico - Buscando topico por id:${id}")
        return topicos.stream().filter { t -> t.id == id }.findFirst().get()
    }

    fun deletar(id: String) {
        logger.info("M=deletar - Deletando tópico com id:${id}")
        val topicoSalvo = topicos.stream().filter { t -> t.id == id }.findFirst().get()
        topicos = topicos.minus(topicoSalvo)
    }
}