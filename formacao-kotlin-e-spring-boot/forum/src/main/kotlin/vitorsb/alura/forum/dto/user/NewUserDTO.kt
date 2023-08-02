package vitorsb.alura.forum.dto.user

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NewUserDTO(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val name: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 160)
    val email: String
)