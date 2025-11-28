package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;

@Entity
public class Comision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double porcentaje;
    private double totalComision;

    @OneToOne
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    public Long getId() {
        return id;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(double totalComision) {
        this.totalComision = totalComision;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }
}