package vitorsb.alura.forum.mapper

interface GenericMapper<T, U> {
    fun map(t: T): U
}
