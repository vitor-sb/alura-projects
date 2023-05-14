package models

class SistemaInterno {
    fun entrar(admin: Autenticavel, senha: Int) {
        if (admin.autentica(senha))
            println("Usuário autenticado!")
        else
            println("Usuário não autenticado!")
    }
}