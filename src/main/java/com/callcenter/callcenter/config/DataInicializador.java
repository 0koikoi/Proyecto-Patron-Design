package com.callcenter.callcenter.config;

import com.callcenter.callcenter.entidad.Operadora;
import com.callcenter.callcenter.entidad.IVR;
import com.callcenter.callcenter.repositorio.OperadoraR;
import com.callcenter.callcenter.repositorio.IVRrepositorio; // Asegúrate del nombre correcto de tu repo
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInicializador {

    @Bean
    public CommandLineRunner initData(OperadoraR operadoraRepo, IVRrepositorio ivrRepo) {
        return args -> {
            //
            if (operadoraRepo.count() == 0) {
                System.out.println("CREANDO OPERADORAS DE PRUEBA...");

                Operadora op1 = new Operadora();
                op1.setNombre("Ana");
                op1.setApellido("Lopez");
                op1.setCodigo("OP-100");
                op1.setExtension("101");
                operadoraRepo.save(op1);

                Operadora op2 = new Operadora();
                op2.setNombre("Carlos");
                op2.setApellido("Ruiz");
                op2.setCodigo("OP-200");
                op2.setExtension("102");
                operadoraRepo.save(op2);
            }

            //
            if (ivrRepo.count() == 0) {
                System.out.println("CREANDO ÁRBOL IVR...");

                // Opción 1: Ventas
                IVR ventas = new IVR();
                ventas.setCodigo("1");
                ventas.setMensaje("Bienvenido a Ventas. Espere un momento.");
                ivrRepo.save(ventas);

                // Opción 2: Soporte
                IVR soporte = new IVR();
                soporte.setCodigo("2");
                soporte.setMensaje("Bienvenido a Soporte Técnico.");
                ivrRepo.save(soporte);

                // Opción Inicio (Saludo)
                IVR saludo = new IVR();
                saludo.setCodigo("Inicio");
                saludo.setMensaje("Hola, gracias por llamar a Claro. Marque 1 para Ventas, 2 para Soporte.");
                ivrRepo.save(saludo);
            }
        };
    }
}