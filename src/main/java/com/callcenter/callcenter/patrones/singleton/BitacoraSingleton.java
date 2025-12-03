package com.callcenter.callcenter.patrones.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BitacoraSingleton {

    private static BitacoraSingleton instancia;
    private List<String> historial;

    private BitacoraSingleton() {
        historial = new ArrayList<>();
    }

    //método estático para el acceso
    public static BitacoraSingleton getInstancia() {
        if (instancia == null) {
            instancia = new BitacoraSingleton();
        }
        return instancia;
    }

    public void registrar(String accion) {
        String log = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "] " + accion;
        historial.add(log);
        System.out.println("BITÁCORA: " + log);
    }

    public List<String> getHistorial() {
        return historial;
    }
}