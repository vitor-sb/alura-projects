package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import vitorsb.alura.forum.dto.topic.UpdateTopicDTO
import vitorsb.alura.forum.dto.topic.NewTopicDTO
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.mapper.TopicMapper
import vitorsb.alura.forum.repository.TopicRepository

@Service
class TopicService(
    private val courseService: CourseService,
    private val userService: UserService,
    private val topicMapper: TopicMapper,
    private val topicRepository: TopicRepository
) {

    private val logger = LoggerFactory.getLogger(TopicService::class.java)

    fun create(dto: NewTopicDTO): TopicDTO {
        logger.info("M=create:TopicDTO - Creating topic")

        val course = courseService.getById(dto.courseId)
        val author = userService.getById(dto.authorId)

        val persistedTopic = topicRepository.create(topicMapper.dtoToModel(dto, course, author))
        return topicMapper.modelToDto(persistedTopic)
    }

    fun update(dto: UpdateTopicDTO): TopicDTO {
        logger.info("M=update:TopicDTO - Updating topic with id:${dto.id}")
        val oldTopic = topicRepository.getById(dto.id)
        val updatedTopic = topicMapper.updateTopic(oldTopic, dto)
        return topicMapper.modelToDto(topicRepository.update(updatedTopic))
    }

    fun list(): List<TopicDTO> {
        logger.info("M=list:List<TopicDTO> - Listing existing topics")
        return topicRepository.list()
    }

    fun getById(id: String): TopicDTO {
        logger.info("M=getById:TopicDTO - Retrieving topic by id:${id}")
        return topicMapper.modelToDto(topicRepository.getById(id))
    }

    fun getTopicById(id: String): Topic {
        logger.info("M=getTopicById:Topic - Retrieving topic by id:${id}")
        return topicRepository.getById(id)
    }

    fun delete(id: String) {
        logger.info("M=delete - Deleting topic with id:${id}")
        topicRepository.delete(id)
    }
}
