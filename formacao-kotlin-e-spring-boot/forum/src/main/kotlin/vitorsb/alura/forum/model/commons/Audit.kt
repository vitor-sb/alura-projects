package vitorsb.alura.forum.model.commons

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
class Audit : Serializable {
    @get:NotNull
    @Column(name = "removed", nullable = false)
    var removed: Boolean = false

    @CreatedBy
    var createdBy: String? = null

    @CreatedDate
    var createdDate: LocalDateTime? = null

    @LastModifiedBy
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
