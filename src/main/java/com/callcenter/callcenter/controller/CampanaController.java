package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.entidad.Campana;
import com.callcenter.callcenter.patrones.factory.CampanaFactory;
import com.callcenter.callcenter.servicio.CampanaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campanas")
public class CampanaController {

    private final CampanaServicio servicio;
    private final CampanaFactory factory;

    // CORRECCIÓN 1: Inyectar el factory en los parámetros
    public CampanaController(CampanaServicio servicio, CampanaFactory factory) {
        this.servicio = servicio;
        this.factory = factory;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("campanas", servicio.listar());
        return "campanas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("campana", new Campana());
        return "campanas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Campana campanaDesdeFormulario) {
        // CORRECCIÓN 2: Extraer nombre y tipo del objeto que viene del HTML
        String nombre = campanaDesdeFormulario.getNombre();
        String tipo = campanaDesdeFormulario.getTipo();

        // Usamos el Factory para crear la campaña con su script automático
        Campana nuevaCampana = factory.crearCampana(nombre, tipo);

        // Guardamos en BD
        servicio.guardar(nuevaCampana);

        return "redirect:/campanas";
    }
}