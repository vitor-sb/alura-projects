package vitorsb.alura.forum.mapper

import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import vitorsb.alura.forum.commons.interfaces.Mappable
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.entity.Topic
import java.time.LocalDateTime
import java.util.*

@Component
object TopicMapper : Mappable<Topic, TopicDTO, NewTopicDTO, UpdateTopicDTO> {
    override fun NewTopicDTO.toEntity(): Topic {
        return Topic(
            id = UUID.randomUUID().toString(),
            title = this.title,
            message = this.message,
            course = requireNotNull(this.course) { "M=NewTopicDTO.toEntity - Course attribute is required" },
            author = requireNotNull(this.author) { "M=NewTopicDTO.toEntity - Author attribute is required" }
        )
    }

    override fun Topic.toDto(): TopicDTO {
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

    override fun Topic.toUpdated(updatedDto: UpdateTopicDTO): Topic {
        val updatedTopic = Topic(
            id = this.id,
            title = updatedDto.title,
            message = updatedDto.message,
            course = this.course,
            author = this.author,
            replies = this.replies,
            status = this.status,
        )

        updatedTopic.audit = this.audit
        updatedTopic.audit.lastModifiedDate = LocalDateTime.now()

        return updatedTopic
    }

    override fun Topic.toDeleted(): Topic {
        this.audit.removed = true
        this.audit.lastModifiedDate = LocalDateTime.now()
        return this
    }
}