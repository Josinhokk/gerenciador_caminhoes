package br.com.kayke.gerenciador_caminhoes.repository;

import br.com.kayke.gerenciador_caminhoes.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
    Optional<Object> findByNome(String nome);
}
