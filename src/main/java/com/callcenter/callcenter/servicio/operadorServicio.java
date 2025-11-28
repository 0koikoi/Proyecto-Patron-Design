package com.callcenter.callcenter.servicio;

import com.callcenter.callcenter.modelo.operador;
import java.util.List;

public interface operadorServicio {
    List<operador> listar();
    operador obtenerId(Long id);
    operador guardar(operador operador);
    void eliminar(Long id);
}
