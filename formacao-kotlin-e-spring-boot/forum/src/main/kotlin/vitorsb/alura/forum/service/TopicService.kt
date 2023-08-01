package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.mapper.TopicMapper.delete
import vitorsb.alura.forum.mapper.TopicMapper.toDto
import vitorsb.alura.forum.mapper.TopicMapper.toModel
import vitorsb.alura.forum.mapper.TopicMapper.update
import vitorsb.alura.forum.repository.TopicRepository

@Service
class TopicService(
    private val courseService: CourseService,
    private val userService: UserService,
    private val repository: TopicRepository
) {
    private val notFoundMessage: String = "Topic not found!"

    private val logger = LoggerFactory.getLogger(TopicService::class.java)

    @Transactional
    fun create(dto: NewTopicDTO): TopicDTO {
        logger.info("M=create - Creating topic")
        val course = courseService.getCourseById(dto.courseId)
        val author = userService.getUserById(dto.authorId)

        val persistedTopic = repository.save(dto.toModel(course, author))
        return persistedTopic.toDto()
    }

    @Transactional
    fun update(dto: UpdateTopicDTO): TopicDTO {
        logger.info("M=update - Updating topic with id:${dto.id}")
        val oldTopic = repository.findByIdAndAuditRemovedFalseOrNull(dto.id)
            ?: throw NotFoundException("M=update, topicId=${dto.id} - $notFoundMessage")
        val updatedTopic = oldTopic.update(dto)
        return repository.save(updatedTopic).toDto()
    }

    fun list(): List<TopicDTO> {
        logger.info("M=list - Listing all not removed topics")
        return repository.findAllByAuditRemovedFalse().map {
            it.toDto()
        }
    }

    fun getById(id: String): TopicDTO {
        logger.info("M=getById - Retrieving topic by id:${id}")
        val topic = repository.findByIdAndAuditRemovedFalseOrNull(id)
            ?: throw NotFoundException("M=getById, topicId=${id} - $notFoundMessage")
        return topic.toDto()
    }

    fun getTopicById(id: String): Topic {
        logger.info("M=getTopicById:Topic - Retrieving topic by id:${id}")
        return repository.findByIdAndAuditRemovedFalseOrNull(id)
            ?: throw NotFoundException("M=getTopicById, topicId=${id} - $notFoundMessage")
    }

    @Transactional
    fun delete(id: String) {
        logger.info("M=delete - Deleting topic with id:${id}")
        val topic = repository.findByIdAndAuditRemovedFalseOrNull(id)
            ?: throw NotFoundException("M=getById, topicId=${id} - $notFoundMessage")

        repository.save(topic.delete())
    }
}
