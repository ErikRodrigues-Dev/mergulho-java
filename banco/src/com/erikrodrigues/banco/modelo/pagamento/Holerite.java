package com.erikrodrigues.banco.modelo.pagamento;

import com.erikrodrigues.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Holerite implements  DocumentoPagavel{

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quantidadeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
        this.pago = pago;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quantidadeHoras));
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
