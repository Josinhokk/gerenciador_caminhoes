package br.com.kayke.gerenciador_caminhoes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "motoristas")
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;




}
