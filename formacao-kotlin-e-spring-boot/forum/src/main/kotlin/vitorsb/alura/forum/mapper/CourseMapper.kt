package vitorsb.alura.forum.mapper

import org.springframework.stereotype.Component
import vitorsb.alura.forum.dto.course.CourseDTO
import vitorsb.alura.forum.dto.course.NewCourseDTO
import vitorsb.alura.forum.dto.course.UpdateCourseDTO
import vitorsb.alura.forum.entity.Course
import java.time.LocalDateTime
import java.util.*

@Component
object CourseMapper {
    fun NewCourseDTO.toEntity(): Course {
        return Course(
            id = UUID.randomUUID().toString(),
            name = this.name,
            category = this.category
        )
    }

    fun Course.toDto(): CourseDTO {
        return CourseDTO(
            id = this.id,
            name = this.name,
            category = this.category
        )
    }

    fun Course.update(dto: UpdateCourseDTO): Course {
        val updatedCourse = Course(
            id = this.id,
            name = dto.name,
            category = dto.category
        )

        updatedCourse.audit = this.audit
        updatedCourse.audit.lastModifiedDate = LocalDateTime.now()

        return updatedCourse
    }

    fun Course.delete(): Course {
        this.audit.removed = true
        this.audit.lastModifiedDate = LocalDateTime.now()
        return this
    }
}