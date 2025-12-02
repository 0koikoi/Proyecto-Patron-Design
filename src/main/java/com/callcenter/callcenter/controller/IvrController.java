package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.servicio.IvrServicioSimulado;
import com.callcenter.callcenter.dto.IvrRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ivr")
public class IvrController {
//REST para el simulado. Luis
    private final IvrServicioSimulado ivrService;

    @Autowired
    public IvrController (IvrServicioSimulado ivrService) {
        this.ivrService = ivrService;
    }

    @PostMapping("/responder")
    public ResponseEntity<Map<String, String>> responder(@RequestBody IvrRequest request) {

        String respuesta = ivrService.procesarOpcion(request.getOpcion());

        return ResponseEntity.ok(Map.of("respuesta", respuesta));
    }

}
