/*
 * SourceFile: ControlAgregarUsuario
 * Description: Class who manages the interaction flow of User Story Agregar Usuario
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.agregarUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioAdministrador;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioCliente;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioOperativo;

@Component
@Controller
public class ControlAgregarUsuario {

	@Autowired
	private ServicioAdministrador servicioAdministrador;
	
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private ServicioOperativo servicioOperativo;
	
	@Autowired
	private VistaAgregarUsuario ventana;

	/*
	 * Description: Method who initializes the User Story Agregar Usuario
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: Object usuario
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void inicia(Object usuario) {
		ventana.muestra(this, usuario);
		
	}
}
