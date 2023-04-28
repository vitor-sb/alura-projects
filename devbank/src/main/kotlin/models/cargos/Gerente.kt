package models.cargos

open class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: Int
) : Funcionario(nome = nome, cpf = cpf, salario = salario) {
    var autenticado: Boolean = false

    override val calculaBonificacao get() = this.salario * 0.3

    fun autentica(senha: Int) {
        if (this.senha == senha){
            println("Usuário ${this.nome} autenticado!")
            autenticado =  true
        }
        println("Usuário ${this.nome} não autenticado!")
        autenticado =  false
    }
}