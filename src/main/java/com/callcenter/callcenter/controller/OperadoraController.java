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
        return "operadoras/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("operadora", new Operadora());
        return "operadoras/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Operadora operadora) {
        // Si tiene ID, el servicio sabe que debe actualizar. Si no, crea.
        if (operadora.getId() != null) {
            servicio.actualizar(operadora.getId(), operadora);
        } else {
            servicio.guardar(operadora);
        }
        return "redirect:/operadoras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Operadora op = servicio.buscarPorId(id);
        if (op == null) return "redirect:/operadoras"; // Protección

        model.addAttribute("operadora", op);
        return "operadoras/form"; // Reutilizamos el mismo formulario
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/operadoras";
    }
}