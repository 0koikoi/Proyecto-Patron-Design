package com.callcenter.callcenter.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private llamada llamada;

    private String tipoServicio;
    private double comision;
}
