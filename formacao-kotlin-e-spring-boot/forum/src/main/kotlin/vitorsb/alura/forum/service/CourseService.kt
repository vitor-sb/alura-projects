package vitorsb.alura.forum.service

import org.springframework.stereotype.Service
import vitorsb.alura.forum.model.Course
import java.util.*

@Service
class CourseService(
    var courses: List<Course>
) {
    init {
        val course = Course(
            id = "49070eeb-6634-45b6-9c77-0c5e28959c86",
            name = "Kotlin with Spring Boot",
            category = "Kotlin"
        )

        courses = Arrays.asList(course)
    }

    fun getById(id: String): Course {
        return courses.stream().filter { c -> c.id == id }.findFirst().get()
    }
}
