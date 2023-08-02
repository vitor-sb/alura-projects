package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.entity.Topic
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.mapper.TopicMapper.delete
import vitorsb.alura.forum.mapper.TopicMapper.toDto
import vitorsb.alura.forum.mapper.TopicMapper.toEntity
import vitorsb.alura.forum.mapper.TopicMapper.update
import vitorsb.alura.forum.repository.TopicRepository
import java.util.*

@Service
class TopicService(
    private val repository: TopicRepository,
    private val courseService: CourseService,
    private val userService: UserService
) {
    private val notFoundMessage: String = "Topic not found!"

    private val logger = LoggerFactory.getLogger(TopicService::class.java)

    @Transactional
    fun create(dto: NewTopicDTO): TopicDTO {
        logger.info("M=create - Creating topic")

        dto.course = courseService.getCourseById(dto.courseId)
        dto.author = userService.getUserById(dto.authorId)

        val persistedTopic = repository.save(dto.toEntity())
        return persistedTopic.toDto()
    }

    fun getById(id: String): TopicDTO {
        logger.info("M=getById - Retrieving topic by id:${id}")
        val topic = repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=getById, topicId=${id} - $notFoundMessage")
        }
        return topic.toDto()
    }

    fun getTopicById(id: String): Topic {
        logger.info("M=getTopicById - Retrieving topic by id:${id}")
        return repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=getTopicById, topicId=${id} - $notFoundMessage")
        }
    }

    fun find(
        courseName: Optional<String>,
        pagination: Pageable
    ): Page<TopicDTO> {
        logger.info("M=find, courseName=${courseName} - Running the topic page list function")
        val topicList = if (courseName.isPresent) {
            logger.info("M=find, courseName=${courseName.get()} - " +
                    "Listing pages with all topics not removed by course name")
            repository.findAllByAuditRemovedFalseAndCourseName(courseName.get(), pagination)
        } else {
            logger.info("M=find - Listing pages with all topics not removed")
            repository.findAllByAuditRemovedFalse(pagination)
        }

        return topicList.toDto()
    }

    @Transactional
    fun update(dto: UpdateTopicDTO): TopicDTO {
        logger.info("M=update - Updating topic with id:${dto.id}")
        val oldTopic = repository.findByIdAndAuditRemovedFalse(dto.id).orElseThrow {
            NotFoundException("M=update, topicId=${dto.id} - $notFoundMessage")
        }
        val updatedTopic = oldTopic.update(dto)
        return repository.save(updatedTopic).toDto()
    }

    @Transactional
    fun delete(id: String) {
        logger.info("M=delete - Deleting topic with id:${id}")
        val topic = repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=delete, topicId=${id} - $notFoundMessage")
        }

        repository.save(topic.delete())
    }
}
