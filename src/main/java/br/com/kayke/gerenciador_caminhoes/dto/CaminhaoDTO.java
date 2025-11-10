package br.com.kayke.gerenciador_caminhoes.dto;

import br.com.kayke.gerenciador_caminhoes.model.Base;
import br.com.kayke.gerenciador_caminhoes.model.Modelo;
import br.com.kayke.gerenciador_caminhoes.model.Motorista;
import org.antlr.v4.runtime.misc.NotNull;

public record CaminhaoDTO(String frota,
                          String placa,
                          String numCarga
) {

}
