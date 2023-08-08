package com.erikrodrigues.banco.modelo.pagamento;

public interface DocumentoEstornavel extends DocumentoPagavel {

    void estornarPagamento();
}
