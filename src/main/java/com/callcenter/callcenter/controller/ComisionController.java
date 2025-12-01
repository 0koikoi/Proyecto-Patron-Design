package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.entidad.Comision;
import com.callcenter.callcenter.servicio.ComisionServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ComisionController {

    @RestController
    @RequestMapping("/api/comision")
    @CrossOrigin("*") // Habilita CORS
    
    public class ComisionController{

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

}
