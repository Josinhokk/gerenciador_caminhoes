package br.com.kayke.gerenciador_caminhoes.controller;

import br.com.kayke.gerenciador_caminhoes.dto.CaminhaoDTO;
import br.com.kayke.gerenciador_caminhoes.model.Caminhao;
import br.com.kayke.gerenciador_caminhoes.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaminhaoController {

    @Autowired
    private CaminhaoService servico;

    @GetMapping("/caminhao")
    public List<CaminhaoDTO> obterTodosCaminhoes() {return servico.obterTodosCaminhoes();}

    @PostMapping("/cadastro")
    public ResponseEntity<Caminhao> cadastraCaminhao(@RequestBody CaminhaoDTO dto) {
    Caminhao novoCaminhao = servico.cadastraCaminhao(dto);
    return ResponseEntity.ok(novoCaminhao);
    }

}
