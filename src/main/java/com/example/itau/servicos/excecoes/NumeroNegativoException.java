package com.example.itau.servicos.excecoes;

public class NumeroNegativoException extends RuntimeException{
    public NumeroNegativoException(String message) {
        super(message);
    }
}
