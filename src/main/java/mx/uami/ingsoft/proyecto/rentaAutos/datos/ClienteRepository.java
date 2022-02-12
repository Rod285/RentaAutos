/*
 * SourceFile: ClienteRepository
 * Description: Class who manages the CRUD for the entity Cliente
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/*
	 * Description: Method who finds a Client by client's name
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario
	 * Return Value: Cliente
	 * Date: 12/02/2022
	 */
	Cliente findByNombreUsuario(String nombreDeUsuario);

}
