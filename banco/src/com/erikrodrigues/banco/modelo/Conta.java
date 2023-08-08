package com.erikrodrigues.banco.modelo;

import com.erikrodrigues.banco.modelo.execao.SaldoInsufiecnteException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta() {

    }

    public Conta(Pessoa titular, int agencia, int numero ){
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

   public void depositar(BigDecimal valor) throws IllegalAccessException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalAccessException("Valor deve ser maior que 0");
        }
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        if (getSaldoDisponivel().subtract().compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsufiecnteException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

    public void sacar(BigDecimal valor, BigDecimal taxaSaque) throws IllegalAccessException {
        sacar(valor.add(taxaSaque));
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }

}

