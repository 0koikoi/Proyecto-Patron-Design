package com.callcenter.callcenter.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.callcenter.callcenter.entidad.Campana;

///en teoría,el JPA ya hace esta parte, la lógica se implementa en servicios y se completa con las entidades
public interface CampanaR extends JpaRepository<Campana, Long> {

}
