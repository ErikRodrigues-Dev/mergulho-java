package com.erikrodrigues.banco.modelo.execao;

public class SaldoInsufiecnteException extends RuntimeException{
    public SaldoInsufiecnteException(String message) {
        super(message);
    }
}
