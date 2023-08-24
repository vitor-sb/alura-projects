package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import vitorsb.alura.forum.dto.user.*
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.entity.User
import vitorsb.alura.forum.mapper.UserMapper.toDeleted
import vitorsb.alura.forum.mapper.UserMapper.toDto
import vitorsb.alura.forum.mapper.UserMapper.toEntity
import vitorsb.alura.forum.mapper.UserMapper.toUpdated
import vitorsb.alura.forum.repository.UserRepository

@Service
class UserService(
    private val repository: UserRepository
) {
    private val notFoundMessage: String = "User not found!"

    private val logger = LoggerFactory.getLogger(UserService::class.java)

    @Transactional
    @CacheEvict(value = ["getUserById"], allEntries = true)
    fun create(dto: NewUserDTO): UserDTO {
        logger.debug("M=create - Creating user")

        val persistedUser = repository.save(dto.toEntity())
        return persistedUser.toDto()
    }

    @Cacheable("getUserById")
    fun getUserById(id: String): User {
        logger.debug("M=getUserById - Retrieving user by id:${id}")
        return repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=getUserById, userId=${id} - $notFoundMessage")
        }
    }

    @Transactional
    @CacheEvict(value = ["getUserById"], allEntries = true)
    fun update(dto: UpdateUserDTO): UserDTO {
        logger.debug("M=update - Updating user with id:${dto.id}")
        val oldUser = repository.findByIdAndAuditRemovedFalse(dto.id).orElseThrow {
            NotFoundException("M=update, userId=${dto.id} - $notFoundMessage")
        }
        val updatedUser = oldUser.toUpdated(dto)
        return repository.save(updatedUser).toDto()
    }

    @Transactional
    @CacheEvict(value = ["getUserById"], allEntries = true)
    fun delete(id: String) {
        logger.debug("M=delete - Deleting user with id:${id}")
        val user = repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=delete, userId=${id} - $notFoundMessage")
        }

        repository.save(user.toDeleted())
    }
}
