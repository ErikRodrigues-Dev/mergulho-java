package com.erikrodrigues.banco.app;

import com.erikrodrigues.banco.modelo.*;
import com.erikrodrigues.banco.modelo.atm.CaixaEletronico;
import com.erikrodrigues.banco.modelo.pagamento.Boleto;
import com.erikrodrigues.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) throws IllegalAccessException {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12378965435");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        System.out.println(TipoPessoa.JURIDICA);
        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-08-08T13:02"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Cleber da Silva");
        titular2.setDocumento("32375934425");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123, 987, new BigDecimal("1000"));

        try {
            minhaConta.depositar(new BigDecimal("1500"));
            minhaConta.sacar(new BigDecimal("5000"));
            minhaConta.creditarRendimentos(BigDecimal.valueOf(0.8));
            minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("35000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, 200);
            Holerite salarioFuncionario = new Holerite(titular2, 100, 160);

            caixaEletronico.pagar(salarioFuncionario, minhaConta);
            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);
            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (IllegalAccessException e) {
            System.out.println("Erro ao executar operação na conta: " +e.getMessage());
        }

//        System.out.println("Boleto pago: " +boletoEscola.estaPago());
//        System.out.print("Holerite pago: " +salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.imprimirSaldo(suaConta);


    }
}
