


package com.callcenter.callcenter.patrones.state;
import com.callcenter.callcenter.entidad.Llamada;


public interface EstadoLlamada {
    String nombreEstado();
    void manejar(Llamada llamada);
}
