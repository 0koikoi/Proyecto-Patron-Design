package com.callcenter.callcenter.controller;

import com.callcenter.callcenter.patrones.singleton.BitacoraSingleton;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        //para el log en consola
        BitacoraSingleton.getInstancia().registrar("Usuario ingresó al Dashboard Principal");
        return "index";//la carga del index
    }
}