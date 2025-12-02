package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;

@Entity //tabla
public class Comision {
//pagos adicionales por venta hecha
    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //crea el id
    private Long id;

    private double porcentaje;
    private double totalComision;

    @OneToOne
    //cada operadora puede tener un monto de comisión

    @JoinColumn(name = "operadora_id")
    private Operadora operadora; //asocia a la operadora con su monto de comisión respectivo

    public Long getId() {
        return id;
    } //id

    public double getPorcentaje() {
        return porcentaje;
    } //porcentaje de comision

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getTotalComision() {
        return totalComision;
    } //total de la comisión

    public void setTotalComision(double totalComision) {
        this.totalComision = totalComision;
    }

    public Operadora getOperadora() {
        return operadora;
    } //operadora

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }
}