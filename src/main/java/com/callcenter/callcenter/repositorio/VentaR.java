package com.callcenter.callcenter.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.callcenter.callcenter.entidad.Venta;

public interface VentaR extends JpaRepository<Venta, Long> {

}