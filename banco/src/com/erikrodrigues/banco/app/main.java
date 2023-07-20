package com.erikrodrigues.banco.app;

import com.erikrodrigues.banco.modelo.Conta;
import com.erikrodrigues.banco.modelo.Pessoa;

public class main {
    public static void main(String[] args) throws IllegalAccessException {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12378965435");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Cleber da Silva");
        titular2.setDocumento("32375934425");

        Conta minhaConta = new Conta(titular1, 123, 987);
         minhaConta.depositar(30_000);

        Conta suaConta = new Conta(titular2, 123, 987);
        minhaConta.sacar(1_000);

         System.out.println("Titular: " +minhaConta.getTitular().getNome());
         System.out.println("Saldo: " +minhaConta.getSaldo());

         System.out.println("Titular: " +suaConta.getTitular().getNome());
         System.out.println("Saldo: " +suaConta.getSaldo());

    }
}
