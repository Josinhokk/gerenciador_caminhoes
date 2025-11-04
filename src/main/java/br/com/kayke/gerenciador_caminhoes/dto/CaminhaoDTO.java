package br.com.kayke.gerenciador_caminhoes.dto;

import br.com.kayke.gerenciador_caminhoes.model.Base;
import br.com.kayke.gerenciador_caminhoes.model.Motorista;

public record CaminhaoDTO(String frota,
                          String placa,
                          String numCarga
                          ) {
}
