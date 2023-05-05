package models.contas

class ContaPoupanca(
    titular: String,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (this.saldo < valor)
            return println(
                "Conta ${this.numero} não possui o saldo necessário. (Valor: R$$valor)"
            )
        this.saldo -= valor
        println("Sacando valor R$$valor da conta ${this.numero}")
    }
}