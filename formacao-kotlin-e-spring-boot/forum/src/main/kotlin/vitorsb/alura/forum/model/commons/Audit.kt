package vitorsb.alura.forum.model.commons

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull
import ampli.commons.grpc.Audit as AuditProto

@Embeddable
class Audit : Serializable {
    @get:NotNull
    @Column(name = "removed", nullable = false)
    var removed: Boolean = false

    @CreatedBy
    var createdBy: String? = null

    @CreatedDate
    var createdDate: ZonedDateTime? = null

    @LastModifiedBy
    var lastModifiedBy: String? = null

    @LastModifiedDate
    var lastModifiedDate: ZonedDateTime? = null

    fun toProto(): AuditProto {
        return AuditProto.newBuilder()
            .setRemoved(this.removed)
            .setCreatedBy(this.createdBy ?: "")
            .setCreatedDate(this.createdDate?.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) ?: "")
            .setLastModifiedBy(this.lastModifiedBy ?: "")
            .setLastModifiedDate(this.lastModifiedDate?.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) ?: "")
            .build()
    }

    fun createTouch(auditor: String) {
        createdDate = ZonedDateTime.now()
        createdBy = auditor
        lastModifiedDate = ZonedDateTime.now()
        lastModifiedBy = auditor
    }

    fun updateTouch(auditor: String) {
        lastModifiedDate = ZonedDateTime.now()
        lastModifiedBy = auditor
    }

    fun deleteTouch(auditor: String) {
        lastModifiedDate = ZonedDateTime.now()
        lastModifiedBy = auditor
        removed = true
    }

    override fun toString(): String {
        return "Audit(" +
            "removed=$removed, " +
            "createdBy=$createdBy, " +
            "createdDate=$createdDate, " +
            "lastModifiedBy=$lastModifiedBy, " +
            "lastModifiedDate=$lastModifiedDate)"
    }
}
