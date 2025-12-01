package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Comision;
import com.callcenter.callcenter.repositorio.ComisionR;
import com.callcenter.callcenter.servicio.ComisionServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComisionSI implements ComisionServicio{
    private final ComisionR repo;
    
    public ComisionSI(ComisionR repo) { this.repo =repo;}

    @Override
    public List<Comision> listar() {
        return repo.findAll();
    }

    @Override
    public Comision guardar(Comision m) {
        return repo.save(m);
    }

    @Override
    public Comision buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Comision actualizar(Long id, Comision m){
        //busca un existente por id
        Comision existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setPorcentaje(m.getPorcentaje());
        existente.setTotalComision(m.getTotalComision());
        existente.setOperadora(m.getOperadora());

        return repo.save(existente);
    }
    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}