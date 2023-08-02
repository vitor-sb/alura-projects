package vitorsb.alura.forum.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import vitorsb.alura.forum.dto.course.CourseDTO
import vitorsb.alura.forum.dto.course.NewCourseDTO
import vitorsb.alura.forum.dto.course.UpdateCourseDTO
import vitorsb.alura.forum.exception.NotFoundException
import vitorsb.alura.forum.entity.Course
import vitorsb.alura.forum.mapper.CourseMapper.delete
import vitorsb.alura.forum.mapper.CourseMapper.toDto
import vitorsb.alura.forum.mapper.CourseMapper.toEntity
import vitorsb.alura.forum.mapper.CourseMapper.update
import vitorsb.alura.forum.repository.CourseRepository

@Service
class CourseService(
    private val repository: CourseRepository
) {
    private val notFoundMessage: String = "Course not found!"

    private val logger = LoggerFactory.getLogger(CourseService::class.java)

    @Transactional
    fun create(dto: NewCourseDTO): CourseDTO {
        logger.info("M=create - Creating course")

        val persistedCourse = repository.save(dto.toEntity())
        return persistedCourse.toDto()
    }

    fun getCourseById(id: String): Course {
        logger.info("M=getCourseById - Retrieving course by id:${id}")
        return repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=getCourseById, courseId=${id} - $notFoundMessage")
        }

    }

    @Transactional
    fun update(dto: UpdateCourseDTO): CourseDTO {
        logger.info("M=update - Updating course with id:${dto.id}")
        val oldCourse = repository.findByIdAndAuditRemovedFalse(dto.id).orElseThrow {
            NotFoundException("M=update, courseId=${dto.id} - $notFoundMessage")
        }
        val updatedCourse = oldCourse.update(dto)
        return repository.save(updatedCourse).toDto()
    }

    @Transactional
    fun delete(id: String) {
        logger.info("M=delete - Deleting course with id:${id}")
        val course = repository.findByIdAndAuditRemovedFalse(id).orElseThrow {
            NotFoundException("M=delete, courseId=${id} - $notFoundMessage")
        }

        repository.save(course.delete())
    }
}
