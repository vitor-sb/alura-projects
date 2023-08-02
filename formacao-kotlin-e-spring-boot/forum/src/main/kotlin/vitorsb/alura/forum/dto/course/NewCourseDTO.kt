package vitorsb.alura.forum.dto.course

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NewCourseDTO(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val name: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val category: String
)