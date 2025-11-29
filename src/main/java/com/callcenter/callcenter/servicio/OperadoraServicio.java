package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Operadora;
import java.util.List;

public interface OperadoraServicio {
    List<Operadora> listar();
    Operadora guardar(Operadora o);
    Operadora buscarPorId(Long id);
    void eliminar(Long id);
}
