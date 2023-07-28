package vitorsb.alura.forum.mapper.topic

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.TopicView
import vitorsb.alura.forum.mapper.GenericMapper
import vitorsb.alura.forum.model.Topic

@Component
class TopicViewMapper : GenericMapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            creationDate = t.creationDate,
            status = t.status
        )
    }
}
