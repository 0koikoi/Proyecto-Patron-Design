package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity //tabla
public class Campana {
//campaña
//organizar las llamadas
    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //crea el id
    private Long id;

    private String nombre;
    private String tipo; // inbound, outbound, venta, retencion, etc.
    //para el uso del script por campañas
    //sin un script com guión, el operador seguiría escribiendo a mano todo
    private String script;
    private String objetivo;

    @OneToMany(mappedBy = "campana", cascade = CascadeType.ALL) //si se borra una campaña, borra sus llamadas por cascada
    //una campaña puede tener muchas llamadas

    private List<Llamada> llamadas; //asocia la lista de

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

    // También agrega estos dos por si acaso el Factory los pide:
    public void setScript(String script) {
        this.script = script;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}