package com.example.itau.servicos.excecoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {
    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;
}
