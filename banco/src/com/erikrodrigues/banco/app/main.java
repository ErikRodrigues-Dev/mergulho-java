package com.erikrodrigues.banco.app;

import com.erikrodrigues.banco.modelo.*;
import com.erikrodrigues.banco.modelo.atm.CaixaEletronico;
import com.erikrodrigues.banco.modelo.pagamento.Boleto;
import com.erikrodrigues.banco.modelo.pagamento.DocumentoPagavel;
import com.erikrodrigues.banco.modelo.pagamento.Holerite;

public class main {
    public static void main(String[] args) throws IllegalAccessException {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12378965435");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Cleber da Silva");
        titular2.setDocumento("32375934425");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123, 987, 1_500);


        minhaConta.depositar(30_000);
        minhaConta.sacar(1_000);
        minhaConta.creditarRendimentos(0.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        suaConta.debitarTarifaMensal();

        Boleto boletoEscola = new Boleto(titular2, 200);
        Holerite salarioFuncionario = new Holerite(titular2, 100, 160);

        caixaEletronico.pagar(salarioFuncionario, minhaConta);
        caixaEletronico.pagar(boletoEscola, minhaConta);
        System.out.println("Boleto pago: " +boletoEscola.estaPago());
        System.out.print("Holerite pago: " +salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.imprimirSaldo(suaConta);


    }
}
