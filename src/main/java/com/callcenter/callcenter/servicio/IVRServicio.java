package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.IVR;
import java.util.List;

public interface IVRServicio {
    List<IVR> listar();
    IVR guardar(IVR i);
    IVR buscarPorId(Long id);
    IVR actualizar(Long id, IVR i);
    void eliminar(Long id);
}