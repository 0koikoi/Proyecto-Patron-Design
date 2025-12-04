package com.callcenter.callcenter.patrones.state;

import com.callcenter.callcenter.entidad.Llamada;

public class Llamadaenproceso implements EstadoLlamada {

    @Override
    public String getNombre() {
        return "EN PROCESO";
    }

    @Override
    public void siguienteEstado(Llamada llamada) {
        llamada.setEstadoLlamada(new Llamadafinalizada());
    }
}
