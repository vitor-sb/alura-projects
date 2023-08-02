package vitorsb.alura.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import java.util.*

@EnableCaching
@SpringBootApplication
class ForumApplication

fun main(args: Array<String>) {
	TimeZone.setDefault(TimeZone.getTimeZone("utc"))
	runApplication<ForumApplication>(*args)
}
