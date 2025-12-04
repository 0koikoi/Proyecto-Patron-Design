package com.callcenter.callcenter.servicio.implementos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callcenter.callcenter.entidad.Llamada;
import com.callcenter.callcenter.repositorio.LlamadaR;
import com.callcenter.callcenter.servicio.LlamadaServicio;
import com.callcenter.callcenter.patrones.state.Llamadaenproceso;
import com.callcenter.callcenter.patrones.state.Llamadafinalizada;
import com.callcenter.callcenter.patrones.state.Llamadapendiente;
import com.callcenter.callcenter.patrones.state.EstadoCancelado;

@Service
public class LlamadaSI implements LlamadaServicio { 

    private final LlamadaR repo;

    public LlamadaSI(LlamadaR repo) {
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
    public Llamada actualizar(Long id, Llamada l) {
        Llamada existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setTipo(l.getTipo());
        existente.setFecha(l.getFecha());
        existente.setEstado(l.getEstado()); // sincronizado con STATE
        existente.setHuboVenta(l.isHuboVenta());
        existente.setDuracion(l.getDuracion());
        existente.setOperadora(l.getOperadora());
        existente.setCampana(l.getCampana());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Llamada> listarPorOperadora(Long operadoraId) {
        return repo.findByOperadoraId(operadoraId);
    }

    // -------------------------------
    //         PATRÓN STATE
    // -------------------------------

    @Override
    public Llamada iniciarLlamada(Llamada llamada) {
        llamada.setEstadoLlamada(new Llamadapendiente());
        llamada.setEstado("PENDIENTE");
        return repo.save(llamada);
    }

    @Override
    public Llamada marcarEnProgreso(Long id) {
        Llamada llamada = buscarPorId(id);
        if (llamada == null) return null;

        llamada.setEstadoLlamada(new Llamadaenproceso());
        llamada.setEstado("EN_PROGRESO");

        return repo.save(llamada);
    }

    @Override
    public Llamada marcarFinalizada(Long id) {
        Llamada llamada = buscarPorId(id);
        if (llamada == null) return null;

        llamada.setEstadoLlamada(new Llamadafinalizada());
        llamada.setEstado("FINALIZADA");

        return repo.save(llamada);
    }

    @Override
    public Llamada marcarCancelada(Long id) {
        Llamada llamada = buscarPorId(id);
        if (llamada == null) return null;

        llamada.setEstadoLlamada(new EstadoCancelado());
        llamada.setEstado("CANCELADA");

        return repo.save(llamada);
    }
}
