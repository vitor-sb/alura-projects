package vitorsb.alura.forum.commons

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull

@Embeddable
data class Audit(
    @get:NotNull
    @Column(name = "removed", nullable = false)
    var removed: Boolean = false,

    @CreatedBy
    @Column(length = 36)
    var createdBy: String? = null,

    @CreatedDate
    @Column(nullable = false)
    var createdDate: LocalDateTime = LocalDateTime.now()

) : Serializable {
    @LastModifiedBy
    @Column(length = 36)
    var lastModifiedBy: String? = null

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null

    override fun toString(): String {
        return "Audit(" +
                "removed=$removed, " +
                "createdBy=$createdBy, " +
                "createdDate=$createdDate, " +
                "lastModifiedBy=$lastModifiedBy, " +
                "lastModifiedDate=$lastModifiedDate)"
    }
}
