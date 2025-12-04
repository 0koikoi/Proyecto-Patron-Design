package com.callcenter.callcenter.patrones.state;
import com.callcenter.callcenter.entidad.Llamada;

public interface EstadoLlamada {
    String getNombre();
    void siguienteEstado(Llamada llamada);
}

