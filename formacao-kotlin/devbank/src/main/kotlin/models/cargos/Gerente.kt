package models.cargos

open class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: Int
) : Funcionario(nome = nome, cpf = cpf, salario = salario) {
    var autenticado: Boolean = false

    override val bonificacao: Double
        get() {
            if (this.autenticado)
                return this.salario + this.salario * 0.5
            println("Gerente não autenticado.")
            return 0.0
        }

    fun autentica(senha: Int) {
        println("Autenticando usuário...")

        if (this.senha == senha){
            println("Usuário ${this.nome} autenticado!")
            autenticado = true
            return
        }
        println("Usuário ${this.nome} não autenticado!")
        autenticado = false
    }
}