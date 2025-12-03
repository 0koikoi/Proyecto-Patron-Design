package com.callcenter.callcenter.patrones.factory;

import com.callcenter.callcenter.entidad.Campana;
import org.springframework.stereotype.Component;

@Component
public class CampanaFactory {

    //se aplica factory a las campañas para
    //evitar que el operador escriba constantemente los mensajes para cada caso

    public Campana crearCampana(String nombre, String tipo) {
        Campana campana = new Campana();
        campana.setNombre(nombre);
        campana.setTipo(tipo);

        //lógica del Patrón: Configuración automática según tipo
        switch (tipo) {
            case "Venta":
                campana.setScript("Script: Hola, le llamamos de Claro para ofrecerle...");
                campana.setObjetivo("Maximizar ingresos por ventas nuevas.");
                break;
            case "Cobranza":
                campana.setScript("Script: Estimado cliente, recordamos su pago pendiente...");
                campana.setObjetivo("Recuperar cartera de clientes.");
                break;
            case "Fidelizacion":
                campana.setScript("Script: Gracias por estar con nosotros, tiene un bono...");
                campana.setObjetivo("Evitar migración a otra operadora.");
                break;
            default:
                campana.setScript("Script genérico.");
                break;
        }
        return campana;
    }
}