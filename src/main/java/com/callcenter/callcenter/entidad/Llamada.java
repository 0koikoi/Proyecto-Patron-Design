package com.callcenter.callcenter.entidad;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data //olvidé que esto hace getters y setters
public class Llamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private LocalDateTime fecha;
    private String estado;
    private boolean huboVenta = false;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    @ManyToOne
    @JoinColumn(name = "campana_id")
    private Campana campana;

    @ManyToOne
    @JoinColumn(name = "ivr_actual_id")
    private IVR ivrActual;
}