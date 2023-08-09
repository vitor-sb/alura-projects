package vitorsb.alura.forum.commons.interfaces

import vitorsb.alura.forum.commons.Audit

/**
 * Auditable Interface.
 *
 * Required interface for existing entities
 */
interface Auditable {
    val audit: Audit
}
