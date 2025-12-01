package com.callcenter.callcenter.servicio.implementos;

import org.springframework.stereotype.Service;

import java.util.List;

import com.callcenter.callcenter.entidad.Llamada;
import com.callcenter.callcenter.repositorio.LlamadaR;
import com.callcenter.callcenter.servicio.LlamadaServicio;

@Service
public class LlamadaServiceImpl implements LlamadaServicio {

    private final LlamadaR llamadaR;

    public LlamadaServiceImpl(LlamadaR llamadaR) {
        this.llamadaR = llamadaR;
    }

    @Override
    public List<Llamada> listar() {
        return llamadaR.findAll();
    }

    @Override
    public Llamada buscarPorId(Long id) {
        return llamadaR.findById(id)
                .orElseThrow(() -> new RuntimeException("Llamada no encontrada"));
    }

    @Override
    public Llamada guardar(Llamada llamada) {
        return llamadaR.save(llamada);
    }

    @Override
    public Llamada actualizar(Long id, Llamada llamada) {
        Llamada existente = buscarPorId(id);

        existente.setDuracion(llamada.getDuracion());
        existente.setFecha(llamada.getFecha());
        existente.setOperadora(llamada.getOperadora());

        return llamadaR.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        llamadaR.deleteById(id);
    }

    @Override
    public List<Llamada> listarPorOperadora(Long operadoraId) {
        return llamadaR.findByOperadoraId(operadoraId);
    }
}