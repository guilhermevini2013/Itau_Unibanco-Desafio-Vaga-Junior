package com.example.itau.servicos.excecoes;

public class TransacaoNaoFeitaException extends RuntimeException{
    public TransacaoNaoFeitaException(String message) {
        super(message);
    }
}
