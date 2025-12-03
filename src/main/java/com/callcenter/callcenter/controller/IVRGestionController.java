package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.entidad.IVR;
import com.callcenter.callcenter.servicio.IVRServicio;
import org.springframework.stereotype.Controller; // <--- OJO: Controller normal (MVC)
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ivr") // Ruta para el navegador web
public class IVRGestionController {

    private final IVRServicio crudService; // <--- Usa TU servicio CRUD

    public IVRGestionController(IVRServicio crudService) {
        this.crudService = crudService;
    }

    // 1. Mostrar la tabla de configuración
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaOpciones", crudService.listar());
        return "ivr/lista"; // Carga templates/ivr/lista.html
    }

    // 2. Mostrar el formulario para crear nueva opción
    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("ivr", new IVR());
        return "ivr/form"; // Carga templates/ivr/form.html
    }

    // 3. Guardar cambios en la BD
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute IVR ivr) {
        crudService.guardar(ivr);
        return "redirect:/ivr";
    }

    // 4. Cargar la vista del Simulador (El teléfono visual)
    @GetMapping("/simulador")
    public String verSimulador() {
        return "ivr/telefono"; // Carga templates/ivr/telefono.html
    }
}