package com.callcenter.callcenter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callcenter.callcenter.entidad.Comision;
import com.callcenter.callcenter.servicio.ComisionServicio;

    @RestController
    @RequestMapping("/api/comision")
    @CrossOrigin("*") // Habilita CORS

public class ComisionController {
        private final ComisionServicio servicio;

        public ComisionController(ComisionServicio servicio) {
            this.servicio = servicio;
        }

        @GetMapping
        public List<Comision> listar() {
            return servicio.listar();
        }

        @GetMapping("/{id}")
        public Comision obtener(@PathVariable Long id) {
            return servicio.buscarPorId(id);
        }

        @PostMapping
        public Comision guardar(@RequestBody Comision m) {
            return servicio.guardar(m);
        }

        @PutMapping("/{id}")
        public Comision actualizar(@PathVariable Long id, @RequestBody Comision datos) {
            Comision existente = servicio.buscarPorId(id);
            if (existente == null) return null;

            existente.setPorcentaje(datos.getPorcentaje());
            existente.setTotalComision(datos.getTotalComision());
            existente.setOperadora(datos.getOperadora());

            return servicio.guardar(existente);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
            servicio.eliminar(id);
        }
    }
