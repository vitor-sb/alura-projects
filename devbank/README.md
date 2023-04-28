## Utilidades para o For

#### 1. Existe a função downTo para ir do 5 até o 1
    Ex. for (i in 5 downTo 2) {...}

#### 2. Da para pular a contagem para ir de dois em dois, ou mais números
    Ex. for (i in 1..5 step 2) {...}


## Utilidades para o If
#### 1. Da para criar blocos de validação
    Ex. 
        when{
            saldo > 0.0 -> println("O Saldo da conta é positivo!")
            saldo == 0.0 -> println("Sua conta não possui nenhum saldo!")
            else -> println("Sua conta esta com o saldo negativo!")
        }