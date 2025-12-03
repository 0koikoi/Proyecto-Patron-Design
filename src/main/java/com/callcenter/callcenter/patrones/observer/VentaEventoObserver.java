package com.callcenter.callcenter.patrones.observer;

import org.springframework.context.ApplicationEvent;

public class VentaEventoObserver extends ApplicationEvent {
    private String mensaje;

    public VentaEventoObserver (Object source, String mensaje) {
        super(source);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}