package com.callcenter.callcenter.controlador;

import com.callcenter.callcenter.servicio.operadorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class operadorControlador {

    private final operadorServicio operadorServicio;

    public operadorControlador(operadorServicio operadorServicio) {
        this.operadorServicio = operadorServicio;
    }

    @GetMapping("/operadores")
    public String listar(Model model) {
        model.addAttribute("operadores", operadorServicio.listar());
        return "operador/lista";
    }
}
