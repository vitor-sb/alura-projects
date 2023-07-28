package vitorsb.alura.forum.mapper.topic

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.topic.NewTopicForm
import vitorsb.alura.forum.model.Course
import vitorsb.alura.forum.model.Topic
import vitorsb.alura.forum.model.User
import java.util.*

@Component
class NewTopicFormMapper {

    fun map(dto: NewTopicForm, course: Course, author: User): Topic {
        return Topic(
            id = UUID.randomUUID().toString(),
            title = dto.title,
            message = dto.message,
            course = course,
            author = author
        )
    }

}
