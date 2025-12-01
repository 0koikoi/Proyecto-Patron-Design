package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Campana;
import com.callcenter.callcenter.entidad.Llamada;
import com.callcenter.callcenter.repositorio.LlamadaR;
import com.callcenter.callcenter.servicio.LlamadaServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LlamadaSI implements LlamadaServicio{
    //clase abstracta para cada servicio
    private final LlamadaR repo;

    public LlamadaSI (LlamadaR repo) {
        this.repo = repo;
    }

    @Override
    public List<Llamada> listar() {
        return repo.findAll();
    }

    @Override
    public Llamada guardar(Llamada l) {
        return repo.save(l);
    }

    @Override
    public Llamada buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Llamada actualizar(Long id, Llamada l){
        //busca un existente por id
        Llamada existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setTipo(l.getTipo());
        existente.setFecha(l.getFecha());
        existente.setEstado(l.getEstado());
        existente.setHuboVenta(l.isHuboVenta());
        existente.setOperadora(l.getOperadora());
        existente.setCampana(l.getCampana());

        return repo.save(existente);
    }
    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}