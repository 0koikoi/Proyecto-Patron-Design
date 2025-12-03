package com.callcenter.callcenter.patrones.state;
import com.callcenter.callcenter.entidad.Llamada;

public class Llamadaenproceso implements EstadoLlamada {

    @Override
    public String nombreEstado() {
        return "En Proceso";
    }

    @Override
    public void manejar(Llamada llamada) {
        System.out.println("La llamada está siendo atendida.");
    }
}
