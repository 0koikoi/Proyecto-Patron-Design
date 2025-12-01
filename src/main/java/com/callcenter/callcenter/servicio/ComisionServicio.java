package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Comision;
import java.util.List;

public interface ComisionServicio {
    List<Comision> listar();
    Comision guardar(Comision m);
    Comision buscarPorId(Long id);
    Comision actualizar(Long id, Comision m);
    void eliminar(Long id);
}
