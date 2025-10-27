package br.com.kayke.gerenciador_caminhoes.repository;

import br.com.kayke.gerenciador_caminhoes.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {


    List<Caminhao> findByMotoristaIsNull();

    List<Caminhao> findByBaseIsNull();
}
