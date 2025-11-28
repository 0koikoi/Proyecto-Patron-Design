package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Llamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // entrante o saliente
    private LocalDateTime fecha;
    private String estado; // Strategy/State aplicable
    private boolean huboVenta = false;

    @ManyToOne
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    @ManyToOne
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
}