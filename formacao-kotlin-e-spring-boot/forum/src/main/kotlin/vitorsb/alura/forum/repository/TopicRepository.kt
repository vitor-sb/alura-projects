package vitorsb.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vitorsb.alura.forum.model.Topic
import java.util.Optional

@Repository
interface TopicRepository : JpaRepository<Topic, String> {
    fun findByIdAndAuditRemovedFalse(id: String): Optional<Topic>
    fun findAllByAuditRemovedFalse(): List<Topic>
}
