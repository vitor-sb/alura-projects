package service;

import org.junit.jupiter.api.Test;
import vitorsb.alura.model.Funcionario;
import vitorsb.alura.service.BonusService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    BonusService service = new BonusService();

    @Test
    public void bonusDeveRetornarErroParaFuncionarioComSalarioMuitoAlto(){
        // given
        Funcionario funcionario = new Funcionario(
                "Vitor",
                LocalDateTime.now(),
                new BigDecimal("25000")
        );

        // when
        try{
            service.calcularBonus(funcionario);
            fail("M=calcularBonus não lançou exceção!");
        } catch (Exception e){
            assertEquals(
                    "Funcionário com salário superior a R$10.000,00 (Dez mil reais) não pode receber bônus.",
                    e.getMessage()
            );
        }

        // then

    }

    @Test
    public void bonusDeveSerDezPorcentoDoSalario(){
        // given
        Funcionario funcionario = new Funcionario(
                "Vitor",
                LocalDateTime.now(),
                new BigDecimal("2500")
        );

        // when
        BigDecimal bonus = service.calcularBonus(funcionario);

        // then
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveSerDezPorcentoDoSalarioParaSalarioDeExatamenteDezMil(){
        // given
        Funcionario funcionario = new Funcionario(
                "Vitor",
                LocalDateTime.now(),
                new BigDecimal("10000.00")
        );

        // when
        BigDecimal bonus = service.calcularBonus(funcionario);

        // then
        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
