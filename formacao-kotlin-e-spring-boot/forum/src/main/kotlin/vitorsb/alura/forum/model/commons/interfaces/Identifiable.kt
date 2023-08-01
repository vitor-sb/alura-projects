package vitorsb.alura.forum.model.commons.interfaces

import java.io.Serializable

interface Identifiable<String : Serializable> {
    val id: String
}
