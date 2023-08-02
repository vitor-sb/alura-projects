package vitorsb.alura.forum.mapper

import org.springframework.stereotype.Component
import vitorsb.alura.forum.commons.interfaces.Mappable
import vitorsb.alura.forum.dto.user.*
import vitorsb.alura.forum.entity.User
import java.time.LocalDateTime
import java.util.*

@Component
object UserMapper: Mappable<User, UserDTO, NewUserDTO, UpdateUserDTO> {
    override fun NewUserDTO.toEntity(): User {
        return User(
            id = UUID.randomUUID().toString(),
            name = this.name,
            email = this.email
        )
    }

    override fun User.toDto(): UserDTO {
        return UserDTO(
            id = this.id,
            name = this.name,
            email = this.email
        )
    }

    override fun User.update(dto: UpdateUserDTO): User {
        val updatedUser = User(
            id = this.id,
            name = dto.name,
            email = dto.email
        )

        updatedUser.audit = this.audit
        updatedUser.audit.lastModifiedDate = LocalDateTime.now()

        return updatedUser
    }

    override fun User.delete(): User {
        this.audit.removed = true
        this.audit.lastModifiedDate = LocalDateTime.now()
        return this
    }
}