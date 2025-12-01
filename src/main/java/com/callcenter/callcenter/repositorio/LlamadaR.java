package com.callcenter.callcenter.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.callcenter.callcenter.entidad.Llamada;
import java.util.List;

public interface LlamadaR extends JpaRepository<Llamada, Long> {
    List<Llamada> findByOperadoraId(Long operadoraId);
}
