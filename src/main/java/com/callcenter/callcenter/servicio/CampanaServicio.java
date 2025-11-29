package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Campana;
import java.util.List;

public interface CampanaServicio {
    List<Campana> listar();
    Campana guardar(Campana c);
    Campana buscarPorId(Long id);
    void eliminar(Long id);
}
