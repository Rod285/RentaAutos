/*
 * SourceFile: PedidoVehiculoRepository
 * Description: Class who manages the CRUD for the entity PedidoVehiculo
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.PedidoVehiculo;

public interface PedidoVehiculoRepository extends JpaRepository<PedidoVehiculo, Long> {

}
