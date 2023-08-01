package vitorsb.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.model.Topic

@Repository
interface TopicRepository : JpaRepository<Topic, String> {
    fun findByIdAndAuditRemovedFalseOrNull(id: String): Topic?
    fun findAllByAuditRemovedFalse(): List<Topic>
}
