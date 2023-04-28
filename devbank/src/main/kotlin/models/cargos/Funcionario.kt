package models.cargos

open class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
) {
    open val calculaBonificacao get() = this.salario * 0.1

}