package com.example.itau.factory;

import com.example.itau.dto.TransacaoDTO;
import com.example.itau.modelos.Transacao;

import java.time.LocalDateTime;

public class Factory {
    public static Transacao criar(){
        Transacao entidade = new Transacao(1l,100.0, LocalDateTime.now());
        return entidade;
    }
    public static TransacaoDTO criarTransacaoDTO(){
        TransacaoDTO entidadeDTO = new TransacaoDTO(criar());
        return entidadeDTO;
    }
    public static TransacaoDTO criarTransacaoDTOValorNegativo(){
        TransacaoDTO entidadeDTO = new TransacaoDTO(1l,-100.0,LocalDateTime.now());
        return entidadeDTO;
    }
    public static Transacao criarComValorNulo(){
        Transacao entidade = new Transacao(1l,100.0, null);
        return entidade;
    }
    public static TransacaoDTO criarTransacaoDTOComValorNulo(){
        TransacaoDTO entidadeDTO = new TransacaoDTO(criarComValorNulo());
        return entidadeDTO;
    }
}
