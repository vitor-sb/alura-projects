package testes

import models.contas.ContaCorrente
import models.contas.ContaPoupanca

fun testaFuncoesConta() {
    val contaVitor = ContaCorrente("Vitor", 1000)
    contaVitor.deposita(1000.0)

    val contaRex = ContaPoupanca("Rex", 1001)
    contaRex.deposita(1000.0)

    contaVitor.transfere(contaRex, 10.0)
    println("Conta ${contaVitor.numero} - Saldo ${contaVitor.saldo}")
    println("Conta ${contaRex.numero} - Saldo ${contaRex.saldo}")
}

fun testaContasDiferentes() {
    val cc = ContaCorrente(
        titular = "Alex",
        numero = 1000
    )

    val cp = ContaPoupanca(
        titular = "fran",
        numero = 1001
    )

    cc.deposita(1000.0)
    cp.deposita(1000.0)

    cc.saca(100.0)
    cp.saca(100.0)

    cc.transfere(valor = 100.0, contaDestino = cp)
    cp.transfere(valor = 100.0, contaDestino = cc)
}