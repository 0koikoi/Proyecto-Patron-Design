package com.callcenter.callcenter.impl;

import com.callcenter.callcenter.modelo.operador;
import com.callcenter.callcenter.repositorio.operadorRepositorio;
import com.callcenter.callcenter.servicio.operadorServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class operadorImpl implements operadorServicio {

    private final operadorRepositorio repositorio;

    public operadorImpl(operadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<operador> listar() {
        return repositorio.findAll();
    }

    @Override
    public operador obtenerId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public operador guardar(operador operador) {
        return repositorio.save(operador);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}