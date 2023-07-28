package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import vitorsb.alura.forum.dto.topic.UpdateTopicForm
import vitorsb.alura.forum.dto.topic.NewTopicForm
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.dto.topic.TopicView
import vitorsb.alura.forum.mapper.topic.UpdateTopicFormMapper
import vitorsb.alura.forum.mapper.topic.NewTopicFormMapper
import vitorsb.alura.forum.mapper.topic.TopicViewMapper
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService,
    private val topicViewMapper: TopicViewMapper,
    private val newTopicFormMapper: NewTopicFormMapper,
    private val updateTopicFormMapper: UpdateTopicFormMapper,
) {

    private val logger = LoggerFactory.getLogger(TopicService::class.java)

    fun create(dto: NewTopicForm): TopicView {
        logger.info("M=create:TopicView - Creating topic")

        val course = courseService.getById(dto.courseId)
        val author = userService.getById(dto.authorId)
        val topic = newTopicFormMapper.map(dto, course, author)

        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(dto: UpdateTopicForm): TopicView {
        logger.info("M=update:TopicView - Updating topic with id:${dto.id}")
        val savedTopic = topics.stream().filter { t -> t.id == dto.id }.findFirst().get()

        val updatedTopic = updateTopicFormMapper.map(savedTopic, dto)
        topics = topics.minus(savedTopic).plus(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun list(): List<TopicView> {
        logger.info("M=list:List<TopicView> - Listing existing topics")
        return topics.stream().map { t -> topicViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun getById(id: String): TopicView {
        logger.info("M=getById:TopicView - Retrieving topic by id:${id}")
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun getTopicById(id: String): Topic {
        logger.info("M=getTopicById:Topic - Retrieving topic by id:${id}")
        return topics.stream().filter { t -> t.id == id }.findFirst().get()
    }

    fun delete(id: String) {
        logger.info("M=delete - Deleting topic with id:${id}")
        val savedTopic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        topics = topics.minus(savedTopic)
    }
}
