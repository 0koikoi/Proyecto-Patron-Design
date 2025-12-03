package com.callcenter.callcenter.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.callcenter.callcenter.entidad.Venta;
import org.springframework.data.jpa.repository.Query;

public interface VentaR extends JpaRepository<Venta, Long> {
    //el query para sumar los montos
    //coalesce para que devuelva 0 si no hay montos
    @Query("SELECT COALESCE(SUM(v.monto), 0) FROM Venta v")
    double sumarTotalVentas();
}