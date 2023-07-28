package vitorsb.alura.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class ForumApplication

fun main(args: Array<String>) {
	TimeZone.setDefault(TimeZone.getTimeZone("utc"))
	runApplication<ForumApplication>(*args)
}
