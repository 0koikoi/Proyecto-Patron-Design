package com.callcenter.callcenter.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class llamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private operador operador;

    @ManyToOne
    private campana campana;

    private String estado;
    private int duracionSeg;
}
