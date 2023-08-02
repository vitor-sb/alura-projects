package vitorsb.alura.forum.commons.interfaces

import java.io.Serializable

interface Identifiable<String : Serializable> {
    val id: String
}
