package br.com.kayke.gerenciador_caminhoes.repository;

import br.com.kayke.gerenciador_caminhoes.model.Base;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {
    Optional<Base> findByNumBase(int numBase);

    List<Base> findAll();
}
