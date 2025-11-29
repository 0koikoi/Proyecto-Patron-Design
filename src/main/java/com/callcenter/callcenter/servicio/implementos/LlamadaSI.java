package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Llamada;
import com.callcenter.callcenter.repositorio.LlamadaR;
import com.callcenter.callcenter.servicio.LlamadaServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LlamadaSI implements LlamadaServicio{

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
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}