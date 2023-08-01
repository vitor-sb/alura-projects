package vitorsb.alura.forum.model.commons.interfaces

import java.io.Serializable

interface Identifiable<UUID : Serializable> {
    val id: UUID
}
