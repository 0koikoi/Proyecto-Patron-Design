package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Campana {
//no pude ponerle campaña
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo; // inbound, outbound, venta, retencion, etc.

    @OneToMany(mappedBy = "campana", cascade = CascadeType.ALL)
    private List<Llamada> llamadas;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}