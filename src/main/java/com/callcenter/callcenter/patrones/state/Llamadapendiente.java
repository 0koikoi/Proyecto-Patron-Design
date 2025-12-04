package com.callcenter.callcenter.patrones.state;
import com.callcenter.callcenter.entidad.Llamada;

public class Llamadapendiente implements EstadoLlamada {

    @Override
    public String getNombre() {
        return "PENDIENTE";
    }

    @Override
    public void siguienteEstado(Llamada llamada) {
        llamada.setEstadoLlamada(new Llamadaenproceso());
    }
}
