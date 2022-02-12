/*
 * SourceFile: ServicioCliente
 * Description: Class who manages the actions and rules of business for the entity Cliente
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.ClienteRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;

@Component
@Service
public class ServicioCliente {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/*
	 * Description: Method who calls clienteRepository to find a client by client's name 
	 * 				and validates the its password
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario, String contrasenia
	 * Return Value: Cliente
	 * Date: 12/02/2022
	 */
	public Cliente recuperaCliente(String nombreDeUsuario, String contrasenia) {
		Cliente cliente = clienteRepository.findByNombreUsuario(nombreDeUsuario);
		if(cliente != null) {
			if(cliente.getContrasenia().equals(contrasenia)) {
				return cliente;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
