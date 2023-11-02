package com.example.itau.servicos.excecoes.pegadorDeExcecoes;

import com.example.itau.servicos.excecoes.ErrorModel;
import com.example.itau.servicos.excecoes.NumeroNegativoException;
import com.example.itau.servicos.excecoes.TransacaoNaoFeitaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class HandlerException {
    private HttpStatus status;
    @ExceptionHandler(TransacaoNaoFeitaException.class)
    public ResponseEntity<ErrorModel> TransacaoException(TransacaoNaoFeitaException transacaoNaoFeitaException, HttpServletRequest request){
        status = HttpStatus.BAD_REQUEST;
    return ResponseEntity.status(status.value()).body(new ErrorModel(Instant.now(),status.value(),transacaoNaoFeitaException.getMessage(), request.getContextPath()));
    }
    @ExceptionHandler(NumeroNegativoException.class)
    public ResponseEntity<ErrorModel> NumeroNegativoExceprion(NumeroNegativoException numeroNegativoExceprion, HttpServletRequest request){
        status = HttpStatus.UNPROCESSABLE_ENTITY;
        return ResponseEntity.status(status.value()).body(new ErrorModel(Instant.now(),status.value(),numeroNegativoExceprion.getMessage(), request.getContextPath()));
    }
}
