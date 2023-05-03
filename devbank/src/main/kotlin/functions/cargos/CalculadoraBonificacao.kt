package functions.cargos

import models.cargos.Funcionario

class CalculadoraBonificacao {
    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario){
        println("Nome: ${funcionario.nome} - Bonificação ${funcionario.bonificacao}")
        this.total += funcionario.bonificacao
    }
}