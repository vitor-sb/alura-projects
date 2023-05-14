package models.cargos

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
) : Gerente(nome = nome, cpf = cpf, salario = salario, senha = senha) {

    override val bonificacao: Double
        get() {
            return super.bonificacao + salario
        }

    fun calculaPlr(): Double {
        return this.salario * 0.5
    }
}