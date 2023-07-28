package vitorsb.alura.forum.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import vitorsb.alura.forum.dto.topico.AtualizaTopicoForm
import vitorsb.alura.forum.dto.topico.NovoTopicoForm
import vitorsb.alura.forum.dto.topico.TopicoView
import vitorsb.alura.forum.service.TopicoService
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:String): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid dto: NovoTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView>{
        val topicoCadastrado = service.cadastrar(dto)
        val uri = uriBuilder.path("/topicos/${topicoCadastrado.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoCadastrado)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizaTopicoForm): ResponseEntity<TopicoView>{
        val topicoAtualizado = service.atualizar(dto)
        return ResponseEntity.ok(topicoAtualizado)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: String){
        service.deletar(id)
    }
}