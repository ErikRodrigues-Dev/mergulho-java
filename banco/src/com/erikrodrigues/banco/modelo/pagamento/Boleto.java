package com.erikrodrigues.banco.modelo.pagamento;

import com.erikrodrigues.banco.modelo.Pessoa;

public class Boleto implements DocumentoPagavel{

    private Pessoa beneficiario;
    private double valor;
    private boolean pago;

    public Boleto(Pessoa beneficiario, double valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
    pago = true;
    }
}
