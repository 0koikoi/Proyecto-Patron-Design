package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.ivr.IvrService;
import com.callcenter.callcenter.ivr.dto.IvrRequest;
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

    private final IvrService ivrService;

    @Autowired
    public IvrController (IvrService ivrService) {
        this.ivrService = ivrService;
    }

    @PostMapping("/responder")
    public ResponseEntity<Map<String, String>> responder(@RequestBody IvrRequest request) {

        String respuesta = ivrService.procesarOpcion(request.getOpcion());

        return ResponseEntity.ok(Map.of("respuesta", respuesta));
    }

}
