package br.com.kayke.gerenciador_caminhoes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "caminhoes")
public class Caminhao {
    @Id
    private String frota;

    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String numCarga;
    @Column(nullable = false)
    private Enum modelo;

    @ManyToOne
    @JoinColumn(name = "base_id", nullable = false)
    private Base base;

    @OneToOne
    private Motorista motorista;


}
