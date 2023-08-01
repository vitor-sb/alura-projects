import org.hibernate.SessionFactory
import org.hibernate.stat.Statistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.EntityManagerFactory

@Component
class HibernateStatisticsUtil(@Autowired private val entityManagerFactory: EntityManagerFactory) {

    fun printHibernateStatistics() {
        val statistics: Statistics = entityManagerFactory.unwrap(SessionFactory::class.java).statistics

        // Examples of information available in statistics
        println("Number of open sessions: ${statistics.sessionOpenCount}")
        println("Number of queries executed: ${statistics.queryExecutionCount}")
        println("Number of loaded entities: ${statistics.entityLoadCount}")
    }
}
