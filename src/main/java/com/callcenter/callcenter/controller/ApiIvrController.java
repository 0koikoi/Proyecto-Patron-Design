package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.servicio.IvrServicioSimulado;
import com.callcenter.callcenter.dto.IvrRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController //para datos JSON
@RequestMapping("/api/ivr") //ruta para el simulador
public class ApiIvrController {

    private final IvrServicioSimulado ivrService;

    public ApiIvrController(IvrServicioSimulado ivrService) {
        this.ivrService = ivrService;
    }

    @PostMapping("/responder")
    public ResponseEntity<Map<String, String>> responder(@RequestBody IvrRequest request) {
        String respuesta = ivrService.procesarOpcion(request.getOpcion());
        return ResponseEntity.ok(Map.of("respuesta", respuesta));
    }
}