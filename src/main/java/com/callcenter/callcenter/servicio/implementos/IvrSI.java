package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.IVR;
import com.callcenter.callcenter.repositorio.IVRrepositorio;
import com.callcenter.callcenter.servicio.IVRServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IvrSI implements IVRServicio {

    private final IVRrepositorio repo;

    public IvrSI (IVRrepositorio repo) {
        this.repo = repo;
    }

    @Override
    public List<IVR> listar() {
        return repo.findAll();
    }

    @Override
    public IVR guardar(IVR i) {
        return repo.save(i);
    }

    @Override
    public IVR buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}