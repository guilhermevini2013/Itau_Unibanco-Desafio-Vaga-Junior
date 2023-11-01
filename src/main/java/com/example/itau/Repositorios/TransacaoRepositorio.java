package com.example.itau.Repositorios;

import com.example.itau.modelos.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepositorio extends JpaRepository<Transacao,Long> {
}
