package models.contas

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo: Double = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0){
            this.saldo += valor
            println("Valor R$$valor depositado na conta ${this.numero}")

        }
    }

    fun saca(valor: Double) {
        if (this.saldo < valor)
            return println(
                "Conta ${this.numero} não possui o saldo necessário. (Valor: R$$valor)"
            )
        this.saldo -= valor
        println("Sacando valor R$$valor da conta ${this.numero}")
    }

    fun transfere(
        contaDestino: Conta, valor: Double
    ) {
        println("Iniciando transferência da conta ${this.numero} para ${contaDestino.numero}")
        if (this.saldo < valor)
            return println(
                "Conta ${this.numero} não possui o saldo necessário. (Valor: R$$valor)"
            )

        println("Retirando valor R$$valor da conta ${this.numero}")
        this.saldo -= valor

        contaDestino.deposita(valor)
        println("Transferência realizada!")
    }
}