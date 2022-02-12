/*
 * SourceFile: OperativoRepository
 * Description: Class who manages the CRUD for the entity Operativo
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;

public interface OperativoRepository extends JpaRepository<Operativo, Long> {

	/*
	 * Description: Method who finds an Operative member by operative's name
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario
	 * Return Value: Operativo
	 * Date: 12/02/2022
	 */
	Operativo findByNombreUsuario(String nombreDeUsuario);

}
