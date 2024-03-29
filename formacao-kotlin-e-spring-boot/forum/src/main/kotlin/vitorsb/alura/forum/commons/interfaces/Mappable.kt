package vitorsb.alura.forum.commons.interfaces

/**
 * Generic Mapper Interface.
 *
 * @param <E> Entity
 * @param <D> EntityDTO
 * @param <N> NewEntityDTO
 * @param <U> UpdateEntityDTO
 */
interface Mappable<E, D, N, U> {
    fun N.toEntity(): E

    fun E.toDto(): D

    fun E.toUpdated(updatedDto: U): E

    fun E.toDeleted(): E
}
