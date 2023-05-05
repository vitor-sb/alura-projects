package models.contas

class ContaCorrente(
    titular: String,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        val valorComTaxa = valor + valor * 0.003
        if (this.saldo < valorComTaxa)
            return println(
                "Conta ${this.numero} não possui o saldo necessário. (Valor: R$$valor)"
            )
        this.saldo -= valorComTaxa
        println("Sacando valor R$$valorComTaxa da conta ${this.numero}")
    }
}