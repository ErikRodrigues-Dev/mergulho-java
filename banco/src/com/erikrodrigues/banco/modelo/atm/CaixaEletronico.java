package com.erikrodrigues.banco.modelo.atm;

import com.erikrodrigues.banco.modelo.Conta;
import com.erikrodrigues.banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        System.out.println("Conta: " +conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " +conta.getTitular().getNome());
        System.out.println("Saldo: "+conta.getSaldo());
        System.out.println("Saldo disponível: "+conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta) throws IllegalAccessException {
            if (documento.estaPago()){
                throw new IllegalAccessException("Documento já esta pago");
            }
            conta.sacar(documento.getValorTotal());
            documento.quitarPagamento();
    }
}
