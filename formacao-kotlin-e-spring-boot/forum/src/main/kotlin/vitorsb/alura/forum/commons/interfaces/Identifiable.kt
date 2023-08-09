package vitorsb.alura.forum.commons.interfaces

import java.io.Serializable

/**
 * Identifiable Interface.
 *
 * Required interface for existing entities
 */

interface Identifiable<String : Serializable> {
    val id: String
}
