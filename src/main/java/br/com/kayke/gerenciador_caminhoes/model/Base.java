package br.com.kayke.gerenciador_caminhoes.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "bases")
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numBase;

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Operador operador;

    @OneToMany(mappedBy = "base", cascade = CascadeType.ALL)
    private List<Caminhao> caminhoes;


}