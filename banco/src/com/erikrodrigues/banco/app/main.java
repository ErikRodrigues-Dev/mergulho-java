package com.erikrodrigues.banco.app;

import com.erikrodrigues.banco.modelo.Conta;
import com.erikrodrigues.banco.modelo.ContaEspecial;
import com.erikrodrigues.banco.modelo.ContaInvestimento;
import com.erikrodrigues.banco.modelo.Pessoa;

public class main {
    public static void main(String[] args) throws IllegalAccessException {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12378965435");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Cleber da Silva");
        titular2.setDocumento("32375934425");

//      ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123, 987, 1_500);
//        minhaConta.depositar(30_000);
//        minhaConta.sacar(1_000);
//        minhaConta.creditarRendimentos(0.8);

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);

//        System.out.println("Titular: " +minhaConta.getTitular().getNome());
//        System.out.println("Saldo: " +minhaConta.getSaldo());

        System.out.println("Titular: " +suaConta.getTitular().getNome());
        System.out.println("Saldo: " +suaConta.getSaldo());

    }
}
