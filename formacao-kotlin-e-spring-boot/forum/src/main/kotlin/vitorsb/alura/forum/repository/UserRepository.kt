package vitorsb.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.entity.User
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, String>{
    fun findByIdAndAuditRemovedFalse(id: String): User?

    fun findByEmail(email:String): User?
}
