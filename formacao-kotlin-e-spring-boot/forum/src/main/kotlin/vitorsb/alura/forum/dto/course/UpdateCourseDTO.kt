package vitorsb.alura.forum.dto.course

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateCourseDTO(
    @field:NotNull
    @field:Size(min = 36, max = 36)
    val id: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val name: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val category: String
)