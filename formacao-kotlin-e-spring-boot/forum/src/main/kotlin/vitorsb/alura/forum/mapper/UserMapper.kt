package vitorsb.alura.forum.mapper

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import vitorsb.alura.forum.commons.interfaces.Mappable
import vitorsb.alura.forum.dto.user.*
import vitorsb.alura.forum.entity.User
import vitorsb.alura.forum.entity.UserDetail
import java.time.LocalDateTime
import java.util.*

@Component
object UserMapper: Mappable<User, UserDTO, NewUserDTO, UpdateUserDTO> {
    override fun NewUserDTO.toEntity(): User {
        return User(
            id = UUID.randomUUID().toString(),
            name = this.name,
            email = this.email,
            password = password
        )
    }

    override fun User.toDto(): UserDTO {
        return UserDTO(
            id = this.id,
            name = this.name,
            email = this.email
        )
    }

    override fun User.toUpdated(updatedDto: UpdateUserDTO): User {
        val updatedUser = User(
            id = this.id,
            name = updatedDto.name,
            email = updatedDto.email,
            password = updatedDto.password
        )

        updatedUser.audit = this.audit
        updatedUser.audit.lastModifiedDate = LocalDateTime.now()

        return updatedUser
    }

    override fun User.toDeleted(): User {
        this.audit.removed = true
        this.audit.lastModifiedDate = LocalDateTime.now()
        return this
    }

    fun User.toUserDetails(): UserDetail {
        return UserDetail(
            username = this.email,
            password = this.password
        )
    }
}