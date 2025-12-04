package com.callcenter.callcenter.controller;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        llamada.setFecha(LocalDateTime.now());

        // El estado inicial lo maneja el servicio, pero lo mostramos vacío aquí
        model.addAttribute("llamada", llamada);
        model.addAttribute("listaOperadoras", operadoraServicio.listar());
        model.addAttribute("listaCampanas", campanaServicio.listar());

        return "llamadas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Llamada llamada) {
        // LOGICA STATE: Si es nueva, iniciamos el flujo. Si existe, actualizamos.
        if (llamada.getId() == null) {
            llamadaServicio.iniciarLlamada(llamada);
        } else {
            llamadaServicio.guardar(llamada);
        }
        return "redirect:/llamadas";
    }

    // --- NUEVO: TRANSICIONES DE ESTADO (State Pattern) ---

    @GetMapping("/contestar/{id}")
    public String contestar(@PathVariable Long id) {
        // PENDIENTE -> EN PROGRESO
        llamadaServicio.marcarEnProgreso(id);
        return "redirect:/llamadas";
    }

    @GetMapping("/finalizar/{id}")
    public String finalizar(@PathVariable Long id) {
        // EN PROGRESO -> FINALIZADA
        llamadaServicio.marcarFinalizada(id);
        return "redirect:/llamadas";
    }
}