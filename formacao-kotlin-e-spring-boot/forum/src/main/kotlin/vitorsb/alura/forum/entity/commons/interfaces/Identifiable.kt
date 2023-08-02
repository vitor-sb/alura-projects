package vitorsb.alura.forum.entity.commons.interfaces

import java.io.Serializable

interface Identifiable<String : Serializable> {
    val id: String
}
