package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.servicio.VentaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    private final VentaServicio ventaServicio;

    public VentaController(VentaServicio ventaServicio) {
        this.ventaServicio = ventaServicio;
    }

    //reporte de ventas de solo lectura
    @GetMapping
    public String listarVentas(Model model) {
        model.addAttribute("listaVentas", ventaServicio.listar());
        model.addAttribute("montoTotal", ventaServicio.calcularTotalVentas()); // Método extra sugerido
        return "ventas/lista"; // templates/ventas/lista.html
    }
}