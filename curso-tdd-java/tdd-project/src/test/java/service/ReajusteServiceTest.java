package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vitorsb.alura.model.Desempenho;
import vitorsb.alura.model.Funcionario;
import vitorsb.alura.service.ReajusteService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    ReajusteService service =  new ReajusteService();
    Funcionario funcionarioPadrao;

    @BeforeEach
    public void inicializar(){
        funcionarioPadrao = new Funcionario("Bia", LocalDateTime.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteDeveSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        // given

        // when
        service.aplicarReajuste(funcionarioPadrao, Desempenho.A_DESEJAR);

        // then
        assertEquals(new BigDecimal("1030.00"), funcionarioPadrao.getSalario());
    }

    @Test
    public void reajusteDeveSerDeQuinzePorcentoQuandoDesempenhoForBom(){
        // given

        // when
        service.aplicarReajuste(funcionarioPadrao, Desempenho.BOM);

        // then
        assertEquals(new BigDecimal("1150.00"), funcionarioPadrao.getSalario());
    }

    @Test
    public void reajusteDeveSerDeVintePorcentoQuandoDesempenhoForOtimo(){
        // given

        // when
        service.aplicarReajuste(funcionarioPadrao, Desempenho.OTIMO);

        // then
        assertEquals(new BigDecimal("1200.00"), funcionarioPadrao.getSalario());
    }

    @Test
    public void reajusteDeveDeZeroEDeveDarErroQuandoDesempenhoForIndefinido(){
        // given

        // when
        service.aplicarReajuste(funcionarioPadrao, Desempenho.INDEFINIDO);

        // then
        assertEquals(new BigDecimal("1000.00"), funcionarioPadrao.getSalario());
    }

}
