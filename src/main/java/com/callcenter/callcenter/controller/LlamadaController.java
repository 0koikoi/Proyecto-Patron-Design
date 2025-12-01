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
import com.callcenter.callcenter.servicio.LlamadaServicio;

@RestController
@RequestMapping("/api/llamadas")
public class LlamadaController {

    private final LlamadaServicio llamadaService;

    public LlamadaController(LlamadaServicio llamadaService) {
        this.llamadaService = llamadaService;
    }

    @GetMapping
    public List<Llamada> listar() {
        return llamadaService.listar();
    }

    @GetMapping("/{id}")
    public Llamada obtener(@PathVariable Long id) {
        return llamadaService.buscarPorId(id);
    }

    @PostMapping
    public Llamada crear(@RequestBody Llamada llamada) {
        return llamadaService.guardar(llamada);
    }

    @PutMapping("/{id}")
    public Llamada actualizar(@PathVariable Long id, @RequestBody Llamada llamada) {
        return llamadaService.actualizar(id, llamada);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        llamadaService.eliminar(id);
    }
}
