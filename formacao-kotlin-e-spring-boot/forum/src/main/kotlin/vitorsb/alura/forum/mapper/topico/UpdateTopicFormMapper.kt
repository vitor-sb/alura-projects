package vitorsb.alura.forum.mapper.topic

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.UpdateTopicForm
import vitorsb.alura.forum.model.Topic
import java.util.*

@Component
class UpdateTopicFormMapper {

    fun map(savedTopic: Topic, updateForm: UpdateTopicForm): Topic {
        return Topic(
            id = UUID.randomUUID().toString(),
            title = updateForm.title,
            message = updateForm.message,
            course = savedTopic.course,
            author = savedTopic.author,
            replies = savedTopic.replies,
            status = savedTopic.status,
            creationDate = savedTopic.creationDate
        )
    }

}
