package com.example.itau.servicos;

import com.example.itau.Repositorios.TransacaoRepositorio;
import com.example.itau.modelos.Transacao;
import com.example.itau.servicos.interfaces.IServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoServico implements IServicos<Transacao> {
    @Autowired
    private TransacaoRepositorio repositorio;
    @Override
    @Transactional
    public Transacao inserir(Transacao transacao) {

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Transacao> listar(PageRequest pageRequest) {
        return null;
    }

    @Override
    @Transactional
    public Void deletar(Long id) {
        return null;
    }
}
