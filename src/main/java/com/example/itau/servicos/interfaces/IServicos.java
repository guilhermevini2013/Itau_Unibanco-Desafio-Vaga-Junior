package com.example.itau.servicos.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IServicos<T> {
    T inserir(T t);
    Page<T> listar(PageRequest pageRequest);
    Void deletar(Long id);
}
