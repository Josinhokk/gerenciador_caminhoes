package br.com.kayke.gerenciador_caminhoes.repository;

import br.com.kayke.gerenciador_caminhoes.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Optional<Motorista> findByNome(String nomeMotorista);
}
