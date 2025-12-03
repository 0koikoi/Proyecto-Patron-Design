package com.callcenter.callcenter.patrones.state;
import com.callcenter.callcenter.entidad.Llamada;

public class Llamadafinalizada implements EstadoLlamada {

    @Override
    public String nombreEstado() {
        return "Finalizada";
    }

    @Override
    public void manejar(Llamada llamada) {
        System.out.println("La llamada terminó. Duración registrada.");
    }
}

