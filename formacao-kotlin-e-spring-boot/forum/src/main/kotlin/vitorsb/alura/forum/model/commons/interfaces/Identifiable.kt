package vitorsb.alura.forum.model.commons.interfaces

import java.io.Serializable

interface Identifiable<ID : Serializable> {
    val id: ID
}
