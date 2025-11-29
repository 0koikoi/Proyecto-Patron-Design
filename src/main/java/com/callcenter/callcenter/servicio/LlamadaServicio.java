package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Llamada;
import java.util.List;

public interface LlamadaServicio {
    List<Llamada> listar();
    Llamada guardar(Llamada l);
    Llamada buscarPorId(Long id);
    void eliminar(Long id);
}
