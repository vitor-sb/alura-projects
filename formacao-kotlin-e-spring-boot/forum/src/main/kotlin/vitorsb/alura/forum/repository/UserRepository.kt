package vitorsb.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.model.User
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, String>{
    fun findByIdAndAuditRemovedFalse(id: String): Optional<User>

}
