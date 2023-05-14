package testes

import models.cargos.Cliente
import models.cargos.Diretor
import models.cargos.Gerente
import models.SistemaInterno

fun testeAutenticacao(){
    val gerenteObj = Gerente(
        nome = "Fer",
        cpf = "111.111.111-11",
        salario = 10000.0,
        senha = 1234
    )

    val diretorObj = Diretor(
        nome = "Naldo",
        cpf = "112.112.112-12",
        salario = 15000.0,
        senha = 36912
    )

    val clienteObj = Cliente(
        nome = "Geremildo",
        cpf = "113.113.113.13",
        senha = 4321
    )

    val sistema = SistemaInterno()
    sistema.entrar(clienteObj, 4321)
    sistema.entrar(gerenteObj, 1234)
    sistema.entrar(diretorObj, 36912)
}