package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.entidad.Comision;
import com.callcenter.callcenter.servicio.ComisionServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //para vistas HTML
@RequestMapping("/comisiones")//direccionamiento, se utiliza para asignar solicitudes a métodos de controladores

public class ComisionController{

    private final ComisionServicio servicio;

    public ComisionController(ComisionServicio servicio){
        this.servicio=servicio;
    }

    //get listar
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("titulo", "Gestión de Comisiones");
        model.addAttribute("comisiones", servicio.listar());
        return "comisiones/lista"; // todo: crear resources/templates/comisiones/lista.html para esta sección
    }

    //guardar post
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Comision comision) {
        servicio.guardar(comision);
        return "redirect:/comisiones"; // Recarga la página
    }

    //delete
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/comisiones";
    }
}