package com.callcenter.callcenter.patrones.strategy;

public class SoporteStrategy implements RespuestaStrategy{
        @Override
        public String responder(String opcion) {
            return "Área de Soporte Técnico. Reinicie su módem y marque 3 si persiste.";
        }
    }