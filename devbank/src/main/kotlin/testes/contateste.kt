package testes

import models.contas.Conta

fun testaFuncoesConta() {
    val contaVitor = Conta("Vitor", 1000)
    contaVitor.deposita(1000.0)

    val contaRex = Conta("Rex", 1001)
    contaRex.deposita(1000.0)

    contaVitor.transfere(contaRex, 10.0)
    println("Conta ${contaVitor.numero} - Saldo ${contaVitor.saldo}")
    println("Conta ${contaRex.numero} - Saldo ${contaRex.saldo}")
}