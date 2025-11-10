package br.com.kayke.gerenciador_caminhoes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "caminhoes")
public class Caminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String frota;

    @Column(nullable = false)
    private String placa;
    @Column()
    private String numCarga;

    @Column(nullable = false)
    private Enum modelo;

    @ManyToOne
    @JoinColumn(name = "base_id")
    private Base base;

    @OneToOne
    private Motorista motorista;

    public Caminhao() {

    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Enum getModelo() {
        return modelo;
    }

    public void setModelo(Enum modelo) {
        this.modelo = modelo;
    }

    public String getNumCarga() {
        return numCarga;
    }

    public void setNumCarga(String numCarga) {
        this.numCarga = numCarga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFrota() {
        return frota;
    }

    public void setFrota(String frota) {
        this.frota = frota;
    }

    public Caminhao(String placa , Enum modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }
}
