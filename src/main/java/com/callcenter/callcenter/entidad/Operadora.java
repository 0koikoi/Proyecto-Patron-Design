package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity //tabla
public class Operadora {
//la persona que atiende las llamadas
    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //crea el id
    private Long id;

    private String nombre;
    private String apellido;
    private String codigo;
    private int totalVentas = 0;
    private String extension; //keyla

    @OneToMany(mappedBy = "operadora", cascade = CascadeType.ALL)
    //uno a muchos, puede haber una operadora para muchas llamadas
    //sabe cuántas llamadas realizó, ventas, calcula comisiones y reportes
    private List<Llamada> llamadas;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}