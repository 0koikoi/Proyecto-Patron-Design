package com.callcenter.callcenter.patrones.state;

import com.callcenter.callcenter.entidad.Llamada;


public class EstadoCancelado implements EstadoLlamada {

    @Override
    public String getNombre() {
        return "CANCELADA";
    }

    @Override
    public void siguienteEstado(Llamada llamada) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
