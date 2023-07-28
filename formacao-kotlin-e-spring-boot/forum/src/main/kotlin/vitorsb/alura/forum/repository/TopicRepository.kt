package vitorsb.alura.forum.repository

import vitorsb.alura.forum.dto.topic.TopicView
import vitorsb.alura.forum.mapper.topic.TopicViewMapper
import vitorsb.alura.forum.model.Topic

class TopicRepository(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
) {
    fun create(topic: Topic): TopicView {
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }
}
