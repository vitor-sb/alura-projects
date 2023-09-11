package service;

import org.junit.jupiter.api.Test;
import vitorsb.alura.model.Desempenho;
import vitorsb.alura.model.Funcionario;
import vitorsb.alura.service.ReajusteService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    ReajusteService service =  new ReajusteService();

    @Test
    public void reajusteDeveSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        // given
        Funcionario funcionario = new Funcionario("Bia", LocalDateTime.now(), new BigDecimal("1000"));

        // when
        service.aplicarReajuste(funcionario, Desempenho.A_DESEJAR);

        // then
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeQuinzePorcentoQuandoDesempenhoForBom(){
        // given
        Funcionario funcionario = new Funcionario("Bia", LocalDateTime.now(), new BigDecimal("1000"));

        // when
        service.aplicarReajuste(funcionario, Desempenho.BOM);

        // then
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerDeVintePorcentoQuandoDesempenhoForOtimo(){
        // given
        Funcionario funcionario = new Funcionario("Bia", LocalDateTime.now(), new BigDecimal("1000"));

        // when
        service.aplicarReajuste(funcionario, Desempenho.OTIMO);

        // then
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveDeZeroEDeveDarErroQuandoDesempenhoForIndefinido(){
        // given
        Funcionario funcionario = new Funcionario("Bia", LocalDateTime.now(), new BigDecimal("1000"));

        // when
        service.aplicarReajuste(funcionario, Desempenho.INDEFINIDO);

        // then
        assertEquals(new BigDecimal("1000.00"), funcionario.getSalario());
    }

}
