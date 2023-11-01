package com.example.itau.dto;

import com.example.itau.modelos.Transacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransacaoDTO {
    private Long id;
    private LocalDateTime dataHora;

    public TransacaoDTO(Transacao entidade) {
        this.id = entidade.getId();
        this.dataHora = entidade.getDataHora();
    }
}
