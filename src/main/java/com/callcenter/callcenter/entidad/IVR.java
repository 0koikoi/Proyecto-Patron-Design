package com.callcenter.callcenter.entidad;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class IVR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "padre_id")
    private IVR padre;

    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL)
    private List<IVR> subOpciones;

    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public IVR getPadre() {
        return padre;
    }

    public void setPadre(IVR padre) {
        this.padre = padre;
    }

    public List<IVR> getSubOpciones() {
        return subOpciones;
    }

    public void setSubOpciones(List<IVR> subOpciones) {
        this.subOpciones = subOpciones;
    }
}