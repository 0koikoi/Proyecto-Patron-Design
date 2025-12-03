package com.callcenter.callcenter.entidad;

import jakarta.persistence.*;

@Entity //tabla
public class Venta {
//ventas hechas durante llamada
    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //crea el id
    private Long id;

    private String tipoServicio; //postpago, internet, tv, renovacion
    private double monto;

    @OneToOne
    //una venta proviene de una llamada
    @JoinColumn(name = "llamada_id")
    private Llamada llamada;

    public Long getId() {
        return id;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Llamada getLlamada() {
        return llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }
}