package com.example.itau.servicos;

import com.example.itau.dto.EstatisticaDTO;
import com.example.itau.dto.TransacaoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class EstatisticaServico {
    @Transactional(readOnly = true)
    public EstatisticaDTO estatistica(List<TransacaoDTO> listTransacaos){
        listTransacaos.sort(Comparator.comparing(TransacaoDTO::getValor));
        return calculaQuantidade(listTransacaos);
    }
    private EstatisticaDTO calculaQuantidade(List<TransacaoDTO> listTransacaos){
        if (listTransacaos.isEmpty()){
            return null;
        }
        double soma = 0;
        for (TransacaoDTO t:listTransacaos) {
            soma+=t.getValor();
        }
        double media = soma/ listTransacaos.size();
        return new EstatisticaDTO(listTransacaos.size(),soma, media,listTransacaos.get(0).getValor(),listTransacaos.get(listTransacaos.size()-1).getValor());
    }
}
