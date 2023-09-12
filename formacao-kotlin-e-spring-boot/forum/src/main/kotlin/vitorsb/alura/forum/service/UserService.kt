package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import vitorsb.alura.forum.dto.user.*
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.entity.User
import vitorsb.alura.forum.exception.UnauthorizedException
import vitorsb.alura.forum.mapper.UserMapper.toDeleted
import vitorsb.alura.forum.mapper.UserMapper.toDto
import vitorsb.alura.forum.mapper.UserMapper.toEntity
import vitorsb.alura.forum.mapper.UserMapper.toUpdated
import vitorsb.alura.forum.mapper.UserMapper.toUserDetails
import vitorsb.alura.forum.repository.UserRepository

@Service
class UserService(
    private val repository: UserRepository
) : UserDetailsService {

    private val logger = LoggerFactory.getLogger(UserService::class.java)

//    @Transactional
//    @CacheEvict(value = ["getUserById"], allEntries = true)
//    fun create(dto: NewUserDTO): UserDTO {
//        logger.info("M=create - Creating user")
//
//        val persistedUser = repository.save(dto.toEntity())
//        return persistedUser.toDto()
//    }

    override fun loadUserByUsername(username: String): UserDetails {
        val foundUser = getUserByEmail(username)

        return foundUser.toUserDetails()
    }

    fun getUserByEmail(email: String): User {
        logger.info("M=getUserByEmail - Retrieving user by id:${email}")

        val foundUser =  repository.findByEmail(email)
            ?: throw NotFoundException("M=getUserByEmail - User with email=${email} not found!")

        if(foundUser.audit.removed)
            throw UnauthorizedException(
                "M=loadUserByUsername - User with email=${email} has been removed!"
            )

        return foundUser
    }

    fun getUserById(id: String): User {
        logger.info("M=getUserById - Retrieving user by id:${id}")
        return repository.findByIdAndAuditRemovedFalse(id)
            ?: throw NotFoundException("M=getUserById - User with userId=${id}, not found!")

    }

//    @Transactional
//    @CacheEvict(value = ["getUserById"], allEntries = true)
//    fun update(dto: UpdateUserDTO): UserDTO {
//        logger.info("M=update - Updating user with id:${dto.id}")
//        val oldUser = repository.findByIdAndAuditRemovedFalse(dto.id).orElseThrow {
//            NotFoundException("M=update, userId=${dto.id} - $notFoundMessage")
//        }
//        val updatedUser = oldUser.toUpdated(dto)
//        return repository.save(updatedUser).toDto()
//    }

//    @Transactional
//    @CacheEvict(value = ["getUserById"], allEntries = true)
//    fun delete(id: String) {
//        logger.info("M=delete - Deleting user with id:${id}")
//        val user = repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
//            NotFoundException("M=delete, userId=${id} - $notFoundMessage")
//        }
//
//        repository.save(user.toDeleted())
//    }
}
