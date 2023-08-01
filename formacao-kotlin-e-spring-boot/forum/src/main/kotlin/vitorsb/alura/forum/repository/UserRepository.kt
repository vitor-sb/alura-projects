package vitorsb.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.model.Course
import vitorsb.alura.forum.model.User

@Repository
interface UserRepository: JpaRepository<User, String>
