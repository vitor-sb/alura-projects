package vitorsb.alura.forum.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.dto.topic.TopicByCategoryDTO
import vitorsb.alura.forum.entity.Topic
import java.util.Optional

@Repository
interface TopicRepository : JpaRepository<Topic, String> {
    fun findByIdAndAuditRemovedFalse(id: String): Optional<Topic>
    fun findAllByAuditRemovedFalse(pagination: Pageable): Page<Topic>
    fun findAllByAuditRemovedFalseAndCourseName(courseName: String, pagination: Pageable): Page<Topic>

    @Query(
        """
        SELECT new vitorsb.alura.forum.dto.topic.TopicByCategoryDTO(course.category, count(t))
        FROM Topic t 
        JOIN t.course course
        WHERE t.audit.removed = false
        GROUP BY course.category
    """
    )
    fun findReport(): List<TopicByCategoryDTO>
}
