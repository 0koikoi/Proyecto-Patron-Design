package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Campana;
import java.util.List;

///*campaña, cada uno de los servicios tiene interface para el CRUD
public interface CampanaServicio {
    List<Campana> listar();
    Campana guardar(Campana c);
    Campana buscarPorId(Long id);
    Campana actualizar(Long id, Campana c);
    void eliminar(Long id);
}
