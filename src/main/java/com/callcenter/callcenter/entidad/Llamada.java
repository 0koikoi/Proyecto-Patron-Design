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

    private String tipo;
    private LocalDateTime fecha;
    private String estado;
    private boolean huboVenta = false;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    @ManyToOne
    @JoinColumn(name = "campana_id")
    private Campana campana;

    @ManyToOne
    @JoinColumn(name = "ivr_actual_id")
    private IVR ivrActual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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

    public IVR getIvrActual() {
        return ivrActual;
    }

    public void setIvrActual(IVR ivrActual) {
        this.ivrActual = ivrActual;
    }
}