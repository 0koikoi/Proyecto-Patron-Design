package com.callcenter.callcenter.patrones.observer;

import com.callcenter.callcenter.patrones.singleton.BitacoraSingleton; // Usamos el Singleton aquí también
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SupervisorListener {

    @EventListener
    public void manejarVenta(VentaEventoObserver evento) {
        //en consola para simular el envio de correos
        System.out.println("[NOTIFICACIÓN IMPORTANTE] Supervisor informado: " + evento.getMensaje());

        //lo guarda en la bitacora
        BitacoraSingleton.getInstancia().registrar("Evento registrado: " + evento.getMensaje());
    }
}