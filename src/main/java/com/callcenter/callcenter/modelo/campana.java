package com.callcenter.callcenter.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class campana {
//no tenemos ñ para esta parte

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String descripcion;
}
