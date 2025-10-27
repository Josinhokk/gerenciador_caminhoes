package br.com.kayke.gerenciador_caminhoes.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "operadores")
public class Operador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "operador", cascade = CascadeType.ALL)
    private List<Base> bases;

    public Operador(String nome) {
        this.nome = nome;
    }
    public Operador() {
    }
}