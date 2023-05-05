package models.cargos

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
) : Gerente(nome = nome, cpf = cpf, salario = salario, senha = senha) {

    override val bonificacao: Double
        get() {
            if (this.autenticado)
                return super.bonificacao + salario
            println("Diretor não autenticado")
            return 0.0

        }

    fun calculaPlr(): Double {
        if (this.autenticado)
            return this.salario * 0.5

        println("Diretor não autenticado")
        return 0.0
    }
}