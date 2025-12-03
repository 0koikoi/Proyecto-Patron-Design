package com.callcenter.callcenter.patrones.state;
import com.callcenter.callcenter.entidad.Llamada;

public class Llamadapendiente implements EstadoLlamada {

    @Override
    public String nombreEstado() {
        return "Pendiente";
    }

    @Override
    public void manejar(Llamada llamada) {
        System.out.println("La llamada está pendiente de ser atendida.");
    }
}
