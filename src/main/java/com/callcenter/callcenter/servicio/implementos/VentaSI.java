package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.entidad.Venta;
import com.callcenter.callcenter.repositorio.VentaR;
import com.callcenter.callcenter.servicio.VentaServicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaSI implements VentaServicio{

    private final VentaR repo;

    public VentaSI (VentaR repo){
        this.repo = repo;
    }

    @Override
    public List<Venta> listar() {
        return repo.findAll();
    }

    @Override
    public Venta guardar(Venta v) {
        return repo.save(v);
    }

    @Override
    public Venta buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
