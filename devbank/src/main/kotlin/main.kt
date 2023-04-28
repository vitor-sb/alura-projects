import model.Conta

fun main() {
    println("Bem vindo ao DevBank!")

    val contaVitor = Conta("Vitor", 1000)
    contaVitor.deposita(1000.0)

    val contaRex = Conta("Rex", 1001)
    contaRex.deposita(1000.0)

    contaVitor.transfere(contaRex, 10.0)
    println(contaVitor.saldo)
    println(contaRex.saldo)

}