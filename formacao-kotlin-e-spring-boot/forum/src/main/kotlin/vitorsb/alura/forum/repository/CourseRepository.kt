package vitorsb.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.model.Course
import java.util.*

@Repository
interface CourseRepository: JpaRepository<Course, String>{
    fun findByIdAndAuditRemovedFalse(id: String): Optional<Course>
}
