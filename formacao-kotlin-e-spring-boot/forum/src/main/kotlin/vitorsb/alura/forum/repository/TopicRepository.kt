package vitorsb.alura.forum.repository

import org.springframework.stereotype.Repository
import vitorsb.alura.forum.dto.topic.TopicDTO
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.mapper.TopicMapper
import vitorsb.alura.forum.model.Topic
import java.util.stream.Collectors

@Repository
class TopicRepository(
    private var topics: List<Topic> = ArrayList(),
    private val topicMapper: TopicMapper
) {
    private val notFoundMessage: String = "Topic not found!"

    fun create(topic: Topic): Topic {
        topics = topics.plus(topic)
        return topic
    }

    fun getById(id: String): Topic {
        return topics.stream().filter { t -> t.id == id }.findFirst()
            .orElseThrow{ NotFoundException("M=getById, topicId=${id} - $notFoundMessage") }
    }

    fun list(): List<TopicDTO> {
        return topics.stream().map { t -> topicMapper.modelToDto(t) }.collect(Collectors.toList())
    }

    fun update(topic: Topic): Topic {
        val oldTopic = topics.stream().filter { t -> t.id == topic.id }.findFirst().get()
        topics = topics.minus(oldTopic).plus(topic)
        return topic
    }

    fun delete(id: String){
        val savedTopic = topics.stream().filter { t -> t.id == id }.findFirst()
            .orElseThrow{ NotFoundException("M=delete, topicId=${id} - $notFoundMessage") }
        topics = topics.minus(savedTopic)
    }
}
