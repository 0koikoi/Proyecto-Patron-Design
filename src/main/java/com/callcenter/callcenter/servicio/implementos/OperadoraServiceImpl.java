package com.callcenter.callcenter.servicio.implementos;



import java.util.List;

import com.callcenter.callcenter.entidad.Operadora;
import com.callcenter.callcenter.repositorio.OperadoraR;
import com.callcenter.callcenter.servicio.OperadoraServicio;

public class OperadoraServiceImpl implements OperadoraServicio {

    private final OperadoraR operadoraR;

    public OperadoraServiceImpl(OperadoraR operadoraR) {
        this.operadoraR = operadoraR;
    }

    @Override
    public List<Operadora> listar() {
        return operadoraR.findAll();
    }

    @Override
    public Operadora buscarPorId(Long id) {
        return operadoraR.findById(id)
                .orElseThrow(() -> new RuntimeException("Operadora no encontrada"));
    }

    @Override
    public Operadora guardar(Operadora operadora) {
        return operadoraR.save(operadora);
    }

    @Override
    public Operadora actualizar(Long id, Operadora operadora) {
        Operadora existente = buscarPorId(id);

        existente.setNombre(operadora.getNombre());
        existente.setExtension(operadora.getExtension());

        return operadoraR.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        operadoraR.deleteById(id);
    }
}

