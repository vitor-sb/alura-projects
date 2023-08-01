package vitorsb.alura.forum.mapper

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.model.Course
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.model.User
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
            creationDate = this.creationDate,
            status = this.status
        )
    }

    fun Topic.update(updatedTopic: UpdateTopicDTO): Topic {
        return Topic(
            id = this.id,
            title = updatedTopic.title,
            message = updatedTopic.message,
            course = this.course,
            author = this.author,
            replies = this.replies,
            status = this.status,
            creationDate = this.creationDate
        )
    }
}