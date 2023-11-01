package com.example.itau.servicos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Service;

@SpringBootTest
public class TransacaoServicoTests {
    @Autowired
    private TransacaoServico transacaoServico;
    @BeforeEach
    void setUp() {

    }

    @Test
    void inserirDeveInserirUmaTransacaoQuandoTodosAtributosForemPreenchidos() {

    }
}
