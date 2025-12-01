package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class IVR {
//ayuda al flujo de llamadas, automatizando la entrada telefónica recibida
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private String codigo;

    @ManyToOne
    //cada opción puede tener subopciones
    @JoinColumn(name = "padre_id")
    private IVR padre;

    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL)
    private List<IVR> subOpciones; //llama a un padre IVr para las opciones

    public Long getId() {
        return id; //id
    }

    public String getMensaje() {
        return mensaje;
    } //mensaje del ivr

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    } //código de este

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public IVR getPadre() {
        return padre;
    }

    public void setPadre(IVR padre) {
        this.padre = padre; //retorna de un padre
    }

    //opciones
    public List<IVR> getSubOpciones() {
        return subOpciones;
    }

    public void setSubOpciones(List<IVR> subOpciones) {
        this.subOpciones = subOpciones;
    } ///opciones de mensaje
}