package com.callcenter.callcenter.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.callcenter.callcenter.entidad.Llamada;
import com.callcenter.callcenter.servicio.CampanaServicio;
import com.callcenter.callcenter.servicio.LlamadaServicio;
import com.callcenter.callcenter.servicio.OperadoraServicio;

@Controller
@RequestMapping("/llamadas")
public class LlamadaController {

    private final LlamadaServicio llamadaServicio;
    private final OperadoraServicio operadoraServicio;
    private final CampanaServicio campanaServicio;

    /*hace llamado a Operadora y Campaña para el registro de llamada*/
    public LlamadaController(LlamadaServicio ls, OperadoraServicio os, CampanaServicio cs) {
        this.llamadaServicio = ls;
        this.operadoraServicio = os;
        this.campanaServicio = cs;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("llamadas", llamadaServicio.listar());
        return "llamadas/lista";
    }

    @GetMapping("/nueva")
    public String nuevaLlamada(Model model) {
        Llamada llamada = new Llamada();
        llamada.setFecha(LocalDateTime.now()); //fecha de llamada
        llamada.setEstado("INICIADA"); // el estado inicial, patrón STATE entra desde acá

        model.addAttribute("llamada", llamada);
        //listas para el select html
        model.addAttribute("listaOperadoras", operadoraServicio.listar());
        model.addAttribute("listaCampanas", campanaServicio.listar());

        return "llamadas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Llamada llamada) {
        //TODO: revisar si entra factory o state
        llamadaServicio.guardar(llamada);
        return "redirect:/llamadas";
    }

    
}