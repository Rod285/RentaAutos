/*
 * SourceFile: AdministradorRepository
 * Description: Class who manages the CRUD for the entity Administrador
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */

package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	/*
	 * Description: Method who finds an Administrator by administrator's name
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario
	 * Return Value: Administrador
	 * Date: 12/02/2022
	 */
	Administrador findByNombreUsuario(String nombreDeUsuario);

}
