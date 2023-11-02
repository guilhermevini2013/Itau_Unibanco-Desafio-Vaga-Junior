package com.example.itau.servicos;

import com.example.itau.Repositorios.TransacaoRepositorio;
import com.example.itau.dto.TransacaoDTO;
import com.example.itau.factory.Factory;
import com.example.itau.modelos.Transacao;
import com.example.itau.servicos.excecoes.TransacaoNaoFeitaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SpringBootTest
public class TransacaoServicoTests {
    @Autowired
    private TransacaoServico transacaoServico;
    @Autowired
    private TransacaoRepositorio transacaoRepositorio;
    private TransacaoDTO transacaoDTO;
    private Transacao transacao;
    private Optional<Transacao> optionalTransacao;
    @BeforeEach
    void setUp() {
        optionalTransacao = null;
        transacaoDTO = null;
    }

    @Test
    void inserirDeveInserirUmaTransacaoQuandoTodosAtributosForemPreenchidos() {
        transacaoDTO = Factory.criarTransacaoDTO();
        transacaoDTO = transacaoServico.inserir(transacaoDTO);
        optionalTransacao = transacaoRepositorio.findById(transacaoDTO.getId());
        Assertions.assertNotNull(optionalTransacao.get());
    }
    @Test
    void inserirDeveLancarTransacaoNaoFeitaExceptionQuandoTiverAtributosVazio(){
        Assertions.assertThrows(TransacaoNaoFeitaException.class,()->{
            try{
                transacaoDTO = Factory.criarTransacaoDTOComValorNulo();
                transacaoDTO = transacaoServico.inserir(transacaoDTO);
            }catch (NullPointerException ex){
                throw new TransacaoNaoFeitaException("Usuario Incorreto");
            }
        });
    }
}
