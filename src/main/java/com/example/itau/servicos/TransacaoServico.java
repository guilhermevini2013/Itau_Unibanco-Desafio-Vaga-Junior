package com.example.itau.servicos;

import com.example.itau.Repositorios.TransacaoRepositorio;
import com.example.itau.dto.TransacaoDTO;
import com.example.itau.modelos.Transacao;
import com.example.itau.servicos.excecoes.NumeroNegativoException;
import com.example.itau.servicos.excecoes.TransacaoNaoFeitaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransacaoServico  {
    @Autowired
    private TransacaoRepositorio repositorio;

    @Transactional
    public TransacaoDTO inserir(TransacaoDTO transacaoDTO) {
        try {
            if (transacaoDTO.getValor() < 0) {
                throw new NumeroNegativoException("Valor negativo");
            }
            Transacao entidade = new Transacao(transacaoDTO);
            entidade = repositorio.save(entidade);
            return new TransacaoDTO(entidade);
        }catch (NullPointerException | NumeroNegativoException ex){
            throw new TransacaoNaoFeitaException("Informacoes incorretas");
        }
    }
    @Transactional
    public List<TransacaoDTO> transacaoList(){
        List<Transacao> list = repositorio.findAll();
        return list.stream().map(x-> new TransacaoDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public void deletar() {
        repositorio.deleteAll();
    }
}
