package br.com.kayke.gerenciador_caminhoes.service;

import br.com.kayke.gerenciador_caminhoes.dto.CaminhaoDTO;
import br.com.kayke.gerenciador_caminhoes.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaminhaoService {
    @Autowired
    CaminhaoRepository caminhaoRepositorio;


    public List<CaminhaoDTO> obterTodosCaminhoes(){
        return caminhaoRepositorio.findAll()
                .stream()
                .map(c -> new CaminhaoDTO(c.getFrota(),c.getPlaca(),c.getNumCarga()))
                .collect(Collectors.toList());
    }
}
