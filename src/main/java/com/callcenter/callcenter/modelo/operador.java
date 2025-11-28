package com.callcenter.callcenter.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int ventasActuales;
    private int metaMensual;

}
