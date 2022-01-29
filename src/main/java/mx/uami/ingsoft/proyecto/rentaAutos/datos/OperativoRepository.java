package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;

public interface OperativoRepository extends JpaRepository<Operativo, Long> {

	Operativo findByNombreUsuario(String nombreDeUsuario);

}
