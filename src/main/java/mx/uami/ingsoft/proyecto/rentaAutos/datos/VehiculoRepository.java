/*
 * SourceFile: VehiculoRepository
 * Description: Class who manages the CRUD for the entity Vehiculo
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

	/*
	 * Description: Method who finds all vehicles of a kind
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String tipo
	 * Return Value: List<Vehiculo>
	 * Date: 12/02/2022
	 */
	List<Vehiculo> findByTipo(String tipo);

}
