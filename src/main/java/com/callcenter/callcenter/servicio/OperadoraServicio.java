package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Operadora;
import java.util.List;

public interface OperadoraServicio {
    List<Operadora> listar();
    Operadora guardar(Operadora o);
    Operadora buscarPorId(Long id);
    Operadora actualizar(Long id , Operadora o);
    void eliminar(Long id);
}