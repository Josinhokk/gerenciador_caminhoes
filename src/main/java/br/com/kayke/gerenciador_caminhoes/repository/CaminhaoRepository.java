package br.com.kayke.gerenciador_caminhoes.repository;

import br.com.kayke.gerenciador_caminhoes.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
}
