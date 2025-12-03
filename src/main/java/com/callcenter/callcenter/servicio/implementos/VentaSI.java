package com.callcenter.callcenter.servicio.implementos;
import com.callcenter.callcenter.patrones.observer.VentaEventoObserver; //importa evento
import com.callcenter.callcenter.entidad.Venta;
import com.callcenter.callcenter.repositorio.VentaR;
import com.callcenter.callcenter.servicio.VentaServicio;
import org.springframework.context.ApplicationEventPublisher; //importa publicador
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaSI implements VentaServicio{

    private final VentaR repo;
    private final ApplicationEventPublisher publisher;

    public VentaSI (VentaR repo, ApplicationEventPublisher publisher){
        this.repo = repo;
        this.publisher = publisher;
    }

    @Override
    public List<Venta> listar() {
        return repo.findAll();
    }

    @Override
    public Venta guardar(Venta v) {
        //guarda la venta en la bd
        Venta nuevaVenta = repo.save(v);
        publisher.publishEvent(new VentaEventoObserver(this, "Nueva venta registrada por monto: " + v.getMonto()));
        return nuevaVenta;
    }

    @Override
    public Venta buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Venta actualizar(Long id, Venta v){
        //busca un existente por id
        Venta existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setTipoServicio(v.getTipoServicio());
        existente.setMonto(v.getMonto());
        existente.setLlamada(v.getLlamada());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public double calcularTotalVentas() {
        return repo.sumarTotalVentas();
    }
}
