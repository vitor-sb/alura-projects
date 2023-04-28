package models.cargos

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
) : Gerente(nome = nome, cpf = cpf, salario = salario, senha = senha) {

    override val calculaBonificacao get() = this.salario * 0.5

    fun calculaPlr(): Double? {
        if (this.autenticado) {
            return this.salario * 3
        }
        println("Diretor não autenticado")
        return null
    }
}