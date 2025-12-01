package com.callcenter.callcenter.servicio;
import com.callcenter.callcenter.entidad.Venta;
import java.util.List;

public interface VentaServicio {
    List<Venta> listar();
    Venta guardar(Venta v);
    Venta buscarPorId(Long id);
    Venta actualizar(Long id, Venta v);
    void eliminar(Long id);
}