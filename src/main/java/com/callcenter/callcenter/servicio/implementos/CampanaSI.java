package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Campana;
import com.callcenter.callcenter.repositorio.CampanaR;
import com.callcenter.callcenter.servicio.CampanaServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampanaSI implements CampanaServicio {
    //clase abstracta para cada servicio
    private final CampanaR repo;

    public CampanaSI(CampanaR repo) {
        this.repo = repo;
    }

    @Override
    public List<Campana> listar() {
        return repo.findAll();
    }

    @Override
    public Campana guardar(Campana c){
        return repo.save(c);
    }

    @Override
    public Campana buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Campana actualizar(Long id, Campana c){
        //busca un existente por id
        Campana existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        //actualiza campos
        existente.setNombre(c.getNombre());
        existente.setTipo(c.getTipo());

        //guarda
        return repo.save(existente); //repetir con todo lloro
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

}
