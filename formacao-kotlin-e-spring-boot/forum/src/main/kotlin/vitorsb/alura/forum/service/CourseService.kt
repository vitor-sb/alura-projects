package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.model.Course
import vitorsb.alura.forum.repository.CourseRepository

@Service
class CourseService(
    private val repository: CourseRepository
) {
    private val notFoundMessage: String = "Course not found!"

    private val logger = LoggerFactory.getLogger(CourseService::class.java)

    fun getCourseById(id: String): Course {
        logger.info("M=getCourseById - Retrieving course by id:${id}")
        return repository.findByIdOrNull(id)
            ?: throw NotFoundException("M=getCourseById, courseId=${id} - $notFoundMessage")

    }
}
