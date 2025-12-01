package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Operadora;
import com.callcenter.callcenter.repositorio.OperadoraR;
import com.callcenter.callcenter.servicio.OperadoraServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OperadoraSI implements OperadoraServicio {
    //clase abstracta para cada servicio
    private final OperadoraR repo;

    public OperadoraSI(OperadoraR repo) {
        this.repo = repo;
    }

    @Override
    public List<Operadora> listar() {
        return repo.findAll();
    }

    @Override
    public Operadora guardar(Operadora o) {
        return repo.save(o);
    }

    @Override
    public Operadora buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Operadora actualizar(Long id, Operadora o){
        //busca un existente por id
        Operadora existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(o.getNombre());
        existente.setApellido(o.getApellido());
        existente.setCodigo(o.getCodigo());
        existente.setTotalVentas(o.getTotalVentas());

        return repo.save(existente);
    }
    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
