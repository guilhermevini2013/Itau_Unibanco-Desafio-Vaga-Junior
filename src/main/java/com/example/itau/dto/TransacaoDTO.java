package com.example.itau.dto;

import com.example.itau.modelos.Transacao;
import com.example.itau.servicos.excecoes.NumeroNegativoExceprion;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TransacaoDTO {
    @NonNull
    private Long id;
    @NonNull
    private Double valor;
    @NonNull
    private LocalDateTime dataHora;

    public TransacaoDTO(Transacao entidade) {
        this.id = entidade.getId();
        this.valor = entidade.getValor();
        this.dataHora = entidade.getDataHora();
    }

    public TransacaoDTO(@NonNull Long id, @NonNull Double valor, @NonNull LocalDateTime dataHora) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
