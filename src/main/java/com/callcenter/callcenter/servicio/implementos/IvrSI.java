package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Campana;
import com.callcenter.callcenter.entidad.IVR;
import com.callcenter.callcenter.repositorio.IVRrepositorio;
import com.callcenter.callcenter.servicio.IVRServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IvrSI implements IVRServicio {
    //clase abstracta para cada servicio
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
    public IVR actualizar(Long id, IVR i){
        //busca un existente por id
        IVR existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        //actualiza campos
        existente.setMensaje(i.getMensaje());
        existente.setCodigo(i.getCodigo());
        existente.setPadre(i.getPadre());

        //guarda
        return repo.save(existente);
    }
    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}