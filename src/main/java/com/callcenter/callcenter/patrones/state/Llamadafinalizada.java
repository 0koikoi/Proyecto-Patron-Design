package com.callcenter.callcenter.patrones.state;

import com.callcenter.callcenter.entidad.Llamada;

public class Llamadafinalizada implements EstadoLlamada {

    @Override
    public String getNombre() {
        return "Finalizada";
    }

    @Override
    public void siguienteEstado(Llamada llamada) {
        // Ya no avanza más
    }
}
