package com.callcenter.callcenter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callcenter.callcenter.entidad.Llamada;
import com.callcenter.callcenter.entidad.Operadora;
import com.callcenter.callcenter.servicio.LlamadaServicio;
import com.callcenter.callcenter.servicio.OperadoraServicio;

@RestController
@RequestMapping("/api/operadoras")
public class OperadoraController {

    private final OperadoraServicio operadoraService;
    private final LlamadaServicio llamadaService;

    public OperadoraController(OperadoraServicio operadoraService, 
                               LlamadaServicio llamadaService) {
        this.operadoraService = operadoraService;
        this.llamadaService = llamadaService;
    }

    @GetMapping
    public List<Operadora> listar() {
        return operadoraService.listar();
    }

    @GetMapping("/{id}")
    public Operadora obtener(@PathVariable Long id) {
        return operadoraService.buscarPorId(id);
    }

    @PostMapping
    public Operadora crear(@RequestBody Operadora operadora) {
        return operadoraService.guardar(operadora);
    }

    @PutMapping("/{id}")
    public Operadora actualizar(@PathVariable Long id, @RequestBody Operadora operadora) {
        return operadoraService.actualizar(id, operadora);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        operadoraService.eliminar(id);
    }

    @GetMapping("/{id}/llamadas")
    public List<Llamada> listarPorOperadora(@PathVariable Long id) {

        // Validar si la operadora existe
        Operadora op = operadoraService.buscarPorId(id);
        if (op == null) {
            throw new RuntimeException("La operadora con ID " + id + " no existe");
        }

        // Llamar al servicio correctamente (como objeto, no como clase)
        return llamadaService.listarPorOperadora(id);
    }
}
