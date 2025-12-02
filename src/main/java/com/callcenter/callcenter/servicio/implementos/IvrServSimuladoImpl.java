package com.callcenter.callcenter.servicio.implementos;

import com.callcenter.callcenter.servicio.IvrServicioSimulado;
import com.callcenter.callcenter.patrones.strategy.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IvrServSimuladoImpl implements IvrServicioSimulado {
    //cambio de nombre a simulado para la lógica del ivr. Luis
    private final Map<String, RespuestaStrategy> estrategiaMap;
    private final RespuestaStrategy defaultStrategy;
    private final RespuestaStrategy operadoraStrategy;

    public IvrServSimuladoImpl() {
        estrategiaMap = new HashMap<>();
        estrategiaMap.put("1",new VentasStrategy());
        estrategiaMap.put("2", new SoporteStrategy());
        this.operadoraStrategy = new RespuestaStrategy() {
            @Override
            public String responder(String opcion) {
                return "Transfiriendo a una operadora. Por favor, espere.";
            }
        };
        estrategiaMap.put("3",operadoraStrategy);
        this.defaultStrategy = new DefaultStrategy();
        //Opcion para el inicio de la llamada
        estrategiaMap.put("Inicio",new SaludoStrategy());
    }
    @Override
    public String procesarOpcion(String opcion) {
        RespuestaStrategy estrategia = estrategiaMap.get(opcion);

        if (estrategia == null) {
            estrategia = defaultStrategy;
        }

        return estrategia.responder(opcion);
    }
}
