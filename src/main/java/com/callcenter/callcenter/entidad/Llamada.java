package com.callcenter.callcenter.entidad;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Llamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; //entrante o saliente
    private LocalDateTime fecha;
    private String estado; //strategy
    private boolean huboVenta = false;
    private int duracion;

    @ManyToOne
    //cada operadora puede tener muchas llamadas
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    @ManyToOne
    //cada campaña puede tener muchas llamadas
    @JoinColumn(name = "campana_id")
    private Campana campana;

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isHuboVenta() {
        return huboVenta;
    }

    public void setHuboVenta(boolean huboVenta) {
        this.huboVenta = huboVenta;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public Campana getCampana() {
        return campana;
    }

    public void setCampana(Campana campana) {
        this.campana = campana;
    }

    public int getDuracion() {
    return duracion;
}

public void setDuracion(int duracion) {
    this.duracion = duracion;
}
}