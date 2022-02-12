/*
 * SourceFile: ServicioAdministrador
 * Description: Class who manages the actions and rules of business for the entity Administrador
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.AdministradorRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;

@Component
@Service
public class ServicioAdministrador {
	
	@Autowired
	private AdministradorRepository administradorRepository;

	/*
	 * Description: Method who calls administradorRepository to find an administrator
	 * 				by user's name and validates the its password
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario, String contrasenia
	 * Return Value: Administrador
	 * Date: 12/02/2022
	 */
	public Administrador recuperaAdministrador(String nombreDeUsuario, String contrasenia) {
		Administrador admin = administradorRepository.findByNombreUsuario(nombreDeUsuario);
		System.out.println("Contraseña introducida: " + contrasenia);
		if(admin != null) {
			System.out.println("Usuario: " + admin.getNombreUsuario());
			System.out.println("contraseña: " + admin.getContrasenia());
			if(contrasenia.equals(admin.getContrasenia())) {
				return admin;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
