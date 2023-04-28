import models.cargos.Diretor
import models.cargos.Funcionario
import models.cargos.Gerente
import testes.testaFuncoesConta

fun main() {
    println("Bem vindo ao DevBank!")
//    testaFuncoesConta()

    println("Criando funcionário")
    val alex = Funcionario(
        nome = "Alex",
        cpf = "111.111.111-11",
        salario = 1000.0
    )
    println("Nome do funcionário: ${alex.nome}")

    println("Criando gerente")
    val fran = Gerente(
        nome = "Fran",
        cpf = "222.222.222-22",
        salario = 10000.0,
        senha = 1234
    )
    println("Nome do gerente: ${fran.nome}")
    println("Autenticando gerente...")
    fran.autentica(1234)

    println("Criando diretor")
    val gui = Diretor(
        nome = "Guilherme",
        cpf = "333.333.333-33",
        salario = 50000.0,
        senha = 4321,
    )
    println("Nome do diretor: ${gui.nome}")
    println("Autenticando diretor...")
    gui.autentica(4321)

}