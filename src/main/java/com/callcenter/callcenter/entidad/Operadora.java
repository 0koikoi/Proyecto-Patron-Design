package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Operadora {
//la persona que atiende las llamadas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String codigo;
    private int totalVentas = 0;

    @OneToMany(mappedBy = "operadora", cascade = CascadeType.ALL)
    //sabe cuántas llamadas realizó, ventas, calcula comisiones y reportes
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }
}