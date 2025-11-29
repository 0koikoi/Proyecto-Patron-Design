package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Campana;
import com.callcenter.callcenter.repositorio.CampanaR;
import com.callcenter.callcenter.servicio.CampanaServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampanaSI implements CampanaServicio {

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
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

}
