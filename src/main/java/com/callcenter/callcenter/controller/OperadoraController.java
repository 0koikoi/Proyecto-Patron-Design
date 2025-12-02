package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.entidad.Operadora;
import com.callcenter.callcenter.servicio.OperadoraServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operadoras")
public class OperadoraController {

    private final OperadoraServicio servicio;

    public OperadoraController(OperadoraServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("operadoras", servicio.listar());
        return "operadoras/lista"; // TODO:  crear templates/operadoras/lista.html
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("operadora", new Operadora());
        return "operadoras/form"; // TODO: crear templates/operadoras/form.html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Operadora operadora) {
        servicio.guardar(operadora);
        return "redirect:/operadoras";
    }
}