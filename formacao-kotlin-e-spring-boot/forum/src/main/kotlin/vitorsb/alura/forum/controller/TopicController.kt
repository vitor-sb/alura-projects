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
import vitorsb.alura.forum.dto.topic.UpdateTopicForm
import vitorsb.alura.forum.dto.topic.NewTopicForm
import vitorsb.alura.forum.dto.topic.TopicView
import vitorsb.alura.forum.service.TopicService
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService
) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): TopicView {
        return service.getById(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid dto: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val createdTopic = service.create(dto)
        val uri = uriBuilder.path("/topics/${createdTopic.id}").build().toUri()
        return ResponseEntity.created(uri).body(createdTopic)
    }

    @PutMapping
    fun update(@RequestBody @Valid dto: UpdateTopicForm): ResponseEntity<TopicView> {
        val updatedTopic = service.update(dto)
        return ResponseEntity.ok(updatedTopic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }
}