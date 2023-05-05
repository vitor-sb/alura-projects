package testes

import functions.cargos.CalculadoraBonificacao
import models.cargos.Analista
import models.cargos.Diretor
import models.cargos.Gerente

fun testaFuncoesCargo(){
    println("Criando funcionário")
    val funcionarioObj = Analista(
        nome = "Alex",
        cpf = "111.111.111-11",
        salario = 2500.0
    )
    println("Nome do funcionário: ${funcionarioObj.nome}")
    println()

    println("Criando gerente")
    val gerenteObj = Gerente(
        nome = "Fran",
        cpf = "222.222.222-22",
        salario = 12500.0,
        senha = 1234
    )
    println("Nome do gerente: ${gerenteObj.nome}")
    println("Testa bonificacao gerente (senha incorreta)...")
    gerenteObj.autentica(1233)
    println(gerenteObj.bonificacao)
    println("Testa plr gerente (senha correta)...")
    gerenteObj.autentica(1234)
    println(gerenteObj.bonificacao)
    println()

    println("Criando diretor")
    val diretorObj = Diretor(
        nome = "Guilherme",
        cpf = "333.333.333-33",
        salario = 25000.0,
        senha = 4321,
    )
    println("Nome do diretor: ${diretorObj.nome}")
    diretorObj.autentica(4322)
    println("Testa plr diretor (senha incorreta)...")
    println(diretorObj.calculaPlr())
    diretorObj.autentica(4321)
    println("Testa plr diretor (senha correta)...")
    println(diretorObj.calculaPlr())
    println()

    println("Criando analista")
    val analistaObj = Analista(
        nome = "Maria",
        cpf = "444.444.444-44",
        salario = 8000.0
    )
    println("Nome do analista ${analistaObj.nome}")
    println()

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(funcionarioObj)
    calculadora.registra(gerenteObj)
    calculadora.registra(diretorObj)
    calculadora.registra(analistaObj)
    println("Total de bonificação: ${calculadora.total}")
}