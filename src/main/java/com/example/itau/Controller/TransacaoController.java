package com.example.itau.Controller;

import com.example.itau.dto.EstatisticaDTO;
import com.example.itau.dto.TransacaoDTO;
import com.example.itau.servicos.EstatisticaService;
import com.example.itau.servicos.TransacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoServico transacaoServico;
    @Autowired
    private EstatisticaService estatisticaService;
    @PostMapping
    public ResponseEntity<TransacaoDTO> inserir(@RequestBody TransacaoDTO dto){
        dto = transacaoServico.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @DeleteMapping
    public ResponseEntity<TransacaoDTO> deletarTodos(){
        transacaoServico.deletar();
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    ResponseEntity<EstatisticaDTO> estatistica(){
        return ResponseEntity.ok(estatisticaService.estatistica(transacaoServico.transacaoList()));
    }

}
