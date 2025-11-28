package com.callcenter.callcenter.servicio;

import com.callcenter.callcenter.modelo.llamada;
import java.util.List;

public interface llamadaServicio {
    List<llamada> listar();
    llamada guardar(llamada llamada);
}
