package vitorsb.alura.service;

import vitorsb.alura.model.Desempenho;
import vitorsb.alura.model.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void aplicarReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);

        funcionario.aplicarReajusteSalarial(reajuste);
    }
}
