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

    public Long getId() {
        return id;
    }

    public int getNumBase() {
        return numBase;
    }

    public Operador getOperador() {
        return operador;
    }

    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setNumBase(int numBase) {
        this.numBase = numBase;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public void setCaminhoes(List<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }

    public Base(int numBase) {
        this.numBase = numBase;
    }
    public Base() {
    }
}