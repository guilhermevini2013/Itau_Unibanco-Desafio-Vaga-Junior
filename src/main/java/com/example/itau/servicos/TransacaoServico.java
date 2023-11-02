package com.example.itau.servicos;

import com.example.itau.Repositorios.TransacaoRepositorio;
import com.example.itau.dto.TransacaoDTO;
import com.example.itau.modelos.Transacao;
import com.example.itau.servicos.excecoes.NumeroNegativoExceprion;
import com.example.itau.servicos.interfaces.IServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransacaoServico implements IServicos<TransacaoDTO> {
    @Autowired
    private TransacaoRepositorio repositorio;
    @Override
    @Transactional
    public TransacaoDTO inserir(TransacaoDTO transacaoDTO) {
        if (transacaoDTO.getValor()<0){
            throw new NumeroNegativoExceprion("Valor negativo");
        }
        Transacao entidade = new Transacao(transacaoDTO);
        entidade = repositorio.save(entidade);
        return new TransacaoDTO(entidade);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransacaoDTO> listar(PageRequest pageRequest) {
        return null;
    }

    @Override
    @Transactional
    public Void deletar(Long id) {
        return null;
    }
}
