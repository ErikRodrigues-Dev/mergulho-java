package com.erikrodrigues.banco.modelo.atm;

import com.erikrodrigues.banco.modelo.Conta;
import com.erikrodrigues.banco.modelo.ContaInvestimento;
import com.erikrodrigues.banco.modelo.pagamento.Boleto;
import com.erikrodrigues.banco.modelo.pagamento.DocumentoEstornavel;
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

    public void estornarPagamento(DocumentoEstornavel documento, Conta conta) throws IllegalAccessException {
        if (!documento.estaPago()) {
            throw new IllegalAccessException("Documento não está pago");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();
    }

}
