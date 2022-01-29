package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.PedidoVehiculo;

public interface PedidoVehiculoRepository extends JpaRepository<PedidoVehiculo, Long> {

}
