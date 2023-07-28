package vitorsb.alura.forum.mapper.topic

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.model.Course
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.model.User
import java.util.*

@Component
class TopicMapper {
    fun dtoToModel(dto: NewTopicDTO, course: Course, author: User): Topic {
        return Topic(
            id = UUID.randomUUID().toString(),
            title = dto.title,
            message = dto.message,
            course = course,
            author = author
        )
    }

    fun modelToDto(t: Topic): TopicDTO {
        return TopicDTO(
            id = t.id,
            title = t.title,
            message = t.message,
            creationDate = t.creationDate,
            status = t.status
        )
    }

    fun updateTopic(oldTopic: Topic, updatedTopic: UpdateTopicDTO): Topic {
        return Topic(
            id = oldTopic.id,
            title = updatedTopic.title,
            message = updatedTopic.message,
            course = oldTopic.course,
            author = oldTopic.author,
            replies = oldTopic.replies,
            status = oldTopic.status,
            creationDate = oldTopic.creationDate
        )
    }
}