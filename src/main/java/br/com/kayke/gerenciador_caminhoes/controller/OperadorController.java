package br.com.kayke.gerenciador_caminhoes.controller;

import br.com.kayke.gerenciador_caminhoes.dto.OperadorDto;
import br.com.kayke.gerenciador_caminhoes.model.Operador;
import br.com.kayke.gerenciador_caminhoes.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadorController {

    @Autowired
    private OperadorService servico;

    @PostMapping("cadastrar")
    public ResponseEntity<Operador> cadastraOperador(@RequestBody OperadorDto dto){

        Operador novoOperador = servico.cadastrarOperador(dto);
        return ResponseEntity.ok(novoOperador);
    }

}
