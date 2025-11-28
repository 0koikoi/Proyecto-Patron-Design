package com.callcenter.callcenter.servicio;

import com.callcenter.callcenter.modelo.campana;
import java.util.List;

public interface campanaServicio {
    List<campana> listar();
    campana obtener(Long id);
    campana guardar(campana c);
    void eliminar(Long id);
}
