package vitorsb.alura.forum.service

import org.springframework.stereotype.Service
import vitorsb.alura.forum.model.Usuario
import java.util.*

@Service
class UsuarioService(
    var usuarios: List<Usuario>
) {
    init {
        var usuario = Usuario(
            id = "fc31377d-bb89-42ba-9bed-0d228bbdde65",
            nome = "Vitor",
            email = "vitor@teste.com"
        )

        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: String): Usuario {
        return usuarios.stream().filter {
                u -> u.id == id
        }.findFirst().get()
    }
}