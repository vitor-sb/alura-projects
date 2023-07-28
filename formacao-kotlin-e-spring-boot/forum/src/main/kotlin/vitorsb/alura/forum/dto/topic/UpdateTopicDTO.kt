package vitorsb.alura.forum.dto.topic

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateTopicDTO(
    @field:NotNull
    val id: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 80)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 255)
    val message: String,
)
