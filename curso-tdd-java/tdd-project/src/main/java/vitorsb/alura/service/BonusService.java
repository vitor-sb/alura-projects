package vitorsb.alura.service;

import vitorsb.alura.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public static BigDecimal valorMaxBonus = new BigDecimal("1000.00");

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(valorMaxBonus) > 0) {
            valor = valorMaxBonus;
        }

        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}
