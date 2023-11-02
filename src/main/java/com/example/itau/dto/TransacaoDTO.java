package com.example.itau.dto;

import com.example.itau.modelos.Transacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TransacaoDTO {
    @NonNull
    @JsonIgnore
    private Long id;
    private Double valor;
    @NonNull
    private LocalDateTime dataHora = LocalDateTime.now();

    public TransacaoDTO(Transacao entidade) {
        this.id = entidade.getId();
        this.valor = entidade.getValor();
        this.dataHora = entidade.getDataHora();
    }

    public TransacaoDTO(@NonNull Long id, @NonNull Double valor) {
        this.id = id;
        this.valor = valor;
    }
}
