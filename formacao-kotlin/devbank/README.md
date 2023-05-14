# DevBank
Projeto criado a partir da formação em kotlin para explicação das atividades e os diferenciais da linguagem.

[Formação Kotlin](https://cursos.alura.com.br/formacao-kotlin)

### jdk 11.0.18

## Anotações
### Utilidades para o For

#### 1. Existe a range expression chamada downTo para ir do 5 até o 1
    Ex. for (i in 5 downTo 2) {...}

#### 2. Da para pular a contagem para ir de dois em dois, ou mais números
    Ex. for (i in 1..5 step 2) {...}


### Utilidades para o If
#### 1. Da para criar blo*c*os de validação
    Ex. 
        when{
            saldo > 0.0 -> println("O Saldo da conta é positivo!")
            saldo == 0.0 -> println("Sua conta não possui nenhum saldo!")
            else -> println("Sua conta esta com o saldo negativo!")
        }

### Interfaces
<p>Conceito da programação orientada a objetos que tem a ver com o comportamento esperado para uma ou um conjunto de classes.
<p>Interfaces definem o que uma classe deve fazer e não como. Assim, interfaces não possuem a implementação de métodos pois apenas declaram o conjunto de métodos, o comportamento que uma ou um conjunto de classes deve ter.
<p>Na interface, todos os métodos são portanto abstratos e públicos, já que são apenas declarados na interface sendo obrigatoriamente implementados pelas classes que implementam a interface.
