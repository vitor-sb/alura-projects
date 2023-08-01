package vitorsb.alura.forum.model.mapper

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.model.Course
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.model.User
import java.time.LocalDateTime
import java.util.*

@Component
object TopicMapper {
    fun NewTopicDTO.toModel(course: Course, author: User): Topic {
        return Topic(
            id = UUID.randomUUID().toString(),
            title = this.title,
            message = this.message,
            course = course,
            author = author
        )
    }

    fun Topic.toDto(): TopicDTO {
        return TopicDTO(
            id = this.id,
            title = this.title,
            message = this.message,
            status = this.status
        )
    }

    fun Topic.update(dto: UpdateTopicDTO): Topic {
        val updatedTopic = Topic(
            id = this.id,
            title = dto.title,
            message = dto.message,
            course = this.course,
            author = this.author,
            replies = this.replies,
            status = this.status,
        )

        updatedTopic.audit = this.audit
        updatedTopic.audit.lastModifiedDate = LocalDateTime.now()

        return updatedTopic
    }

    fun Topic.delete(): Topic {
        this.audit.removed = true
        this.audit.lastModifiedDate = LocalDateTime.now()
        return this
    }
}