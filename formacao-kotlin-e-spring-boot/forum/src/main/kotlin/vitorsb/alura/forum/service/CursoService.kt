package vitorsb.alura.forum.service

import org.springframework.stereotype.Service
import vitorsb.alura.forum.model.Curso
import java.util.*

@Service
class CursoService(
    var cursos: List<Curso>
) {
    init {
        val curso = Curso(
            id = "49070eeb-6634-45b6-9c77-0c5e28959c86",
            nome = "Kotlin com Spring boot",
            categoria = "Kotlin"
        )

        cursos = Arrays.asList(curso)
    }

    fun buscarPorId(id: String): Curso{
        return cursos.stream().filter {
            c -> c.id == id
        }.findFirst().get()
    }
}