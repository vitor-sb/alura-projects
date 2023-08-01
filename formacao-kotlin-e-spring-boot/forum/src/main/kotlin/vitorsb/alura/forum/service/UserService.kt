package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.model.User
import vitorsb.alura.forum.repository.UserRepository

@Service
class UserService(
    private val repository: UserRepository
) {
    private val notFoundMessage: String = "User not found!"

    private val logger = LoggerFactory.getLogger(UserService::class.java)

    fun getUserById(id: String): User {
        logger.info("M=getUserById - Retrieving user by id:${id}")
        return repository.findByIdOrNull(id)
            ?: throw NotFoundException("M=getById, userId=${id} - $notFoundMessage")

    }
}
