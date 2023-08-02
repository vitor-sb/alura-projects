package vitorsb.alura.forum.mapper

import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.entity.Course
import vitorsb.alura.forum.entity.Topic
import vitorsb.alura.forum.entity.User
import java.time.LocalDateTime
import java.util.*

@Component
object TopicMapper {
    fun NewTopicDTO.toEntity(course: Course, author: User): Topic {
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

    fun Page<Topic>.toDto(): Page<TopicDTO> {
        return this.map {
            it.toDto()
        }
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