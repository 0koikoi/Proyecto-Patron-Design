package com.callcenter.callcenter.repositorio;

import com.callcenter.callcenter.modelo.llamada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface llamadaRepositorio extends JpaRepository<llamada, Long> {
}
