package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Campana {
//campaña
//organizar las llamadas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo; // inbound, outbound, venta, retencion, etc.

    @OneToMany(mappedBy = "campana", cascade = CascadeType.ALL) //si se borra una campaña, borra sus llamadas por cascada
    //una campaña puede tener muchas llamadas

    private List<Llamada> llamadas; //asocia la lista de llamadas

    public Long getId() {
        return id;
    } //id de la campaña

    public String getNombre() {
        return nombre;
    } //nombre de esta

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    } //tipo de campaña

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}