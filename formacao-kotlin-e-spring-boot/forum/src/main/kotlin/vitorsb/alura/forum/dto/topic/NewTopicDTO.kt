package vitorsb.alura.forum.dto.topic

import vitorsb.alura.forum.entity.Course
import vitorsb.alura.forum.entity.User
import java.util.Optional
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewTopicDTO(
    @field:NotEmpty
    @field:Size(min = 5, max = 80)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 255)
    val message: String,

    @field:NotNull
    val courseId: String,
    var course: Course? = null,

    @field:NotNull
    val authorId: String,
    var author: User? = null,
)