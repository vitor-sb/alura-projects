package vitorsb.alura.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Funcionario {
    private String nome;
    private LocalDateTime dataAdmissao;
    private BigDecimal salario;

    public void aplicarReajusteSalarial(BigDecimal reajuste) {
        this.salario = this.salario.add(reajuste);
        arredondarSalario();
    }

    private void arredondarSalario() {
        this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
    }
}
