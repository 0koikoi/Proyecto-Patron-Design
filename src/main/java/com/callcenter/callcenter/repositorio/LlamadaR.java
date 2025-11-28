package com.callcenter.callcenter.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.callcenter.callcenter.entidad.Llamada;

public interface LlamadaR extends JpaRepository<Llamada, Long> {

}
