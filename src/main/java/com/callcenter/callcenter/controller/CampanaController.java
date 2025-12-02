package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.entidad.Campana;
import com.callcenter.callcenter.servicio.CampanaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campanas") //campañas*
public class CampanaController {

    private final CampanaServicio servicio;

    public CampanaController(CampanaServicio servicio) {
        this.servicio = servicio;
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
    public String guardar(@ModelAttribute Campana campana) {
        servicio.guardar(campana);
        return "redirect:/campanas";
    }
}