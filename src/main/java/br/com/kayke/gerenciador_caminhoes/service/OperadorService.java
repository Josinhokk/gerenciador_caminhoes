package br.com.kayke.gerenciador_caminhoes.service;

import br.com.kayke.gerenciador_caminhoes.dto.OperadorDto;
import br.com.kayke.gerenciador_caminhoes.model.Operador;
import br.com.kayke.gerenciador_caminhoes.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository OperadorRepository;

    public Operador cadastrarOperador(OperadorDto dto){
        Operador Operador = new Operador();
        Operador.setNome(dto.nome());
        OperadorRepository.save(Operador);

        return Operador;
    }
}
