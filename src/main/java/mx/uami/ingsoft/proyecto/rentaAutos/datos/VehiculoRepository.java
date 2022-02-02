package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

	List<Vehiculo> findByTipo(String tipo);

}
