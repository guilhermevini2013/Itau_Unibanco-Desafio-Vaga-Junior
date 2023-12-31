package com.example.itau.modelos;

import com.example.itau.dto.TransacaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Double valor;
    @NonNull
    private LocalDateTime dataHora;
    public Transacao(TransacaoDTO entidadeDTO){
        this.id=entidadeDTO.getId();
        this.valor=entidadeDTO.getValor();
        this.dataHora=entidadeDTO.getDataHora();
    }
}
