package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Llamada;
import java.util.List;

public interface LlamadaServicio {
    List<Llamada> listar();
    Llamada guardar(Llamada l);
    Llamada buscarPorId(Long id);
    Llamada actualizar(Long id, Llamada l);
    void eliminar(Long id);
    List<Llamada> listarPorOperadora(Long operadoraId);

    // MÉTODOS PARA STATE
    Llamada iniciarLlamada(Llamada llamada);
    Llamada marcarEnProgreso(Long id);
    Llamada marcarFinalizada(Long id);
    Llamada marcarCancelada(Long id);
}

