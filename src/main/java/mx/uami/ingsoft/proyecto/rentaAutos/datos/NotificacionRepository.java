package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}
