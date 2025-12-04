package com.callcenter.callcenter.patrones.strategy;

public class SaludoStrategy implements RespuestaStrategy {
    @Override
    public String responder(String opcion) {
        return "Bienvenido a Claro. Marque 1 para Ventas, 2 para Soporte.";
    }
}