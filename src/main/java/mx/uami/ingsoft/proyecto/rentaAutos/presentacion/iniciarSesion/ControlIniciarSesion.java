/*
 * SourceFile: ControlIniciarSesion
 * Description: Class who manages the interaction flow of User Story Iniciar Sesión
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.iniciarSesion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioAdministrador;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioCliente;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioOperativo;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;
import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalCliente.ControlPrincipalCliente;
import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalOperaciones.ControlPrincipalOperaciones;

@Component
@Controller
public class ControlIniciarSesion {
	
	@Autowired
	private ServicioAdministrador servicioAdministrador;
	
	@Autowired
	private ServicioOperativo servicioOperativo;
	
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private ControlPrincipalCliente controlCliente;
	
	@Autowired
	private ControlPrincipalOperaciones controlOperaciones;
	
	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;
	
	@Autowired
	private VistaIniciarSesion vista;
	
	public void inicia() {
		vista.muestra(this);
	}

	/*
	 * Description: Method who determines the kind of user that is recovered
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario, String contrasenia
	 * Return Value: Object
	 * Date: 12/02/2022
	 */
	public Object validaUsuario(String nombreDeUsuario, String contrasenia) {
		Administrador admin = servicioAdministrador
								.recuperaAdministrador(nombreDeUsuario, contrasenia);
		if(admin != null) {
			System.out.println("Es administrador " + admin.getClass().toString());
			return admin;
		}else {
			Operativo ope = servicioOperativo.recuperaOperativo(nombreDeUsuario, contrasenia);
			if(ope != null) {
				System.out.println("Es operativo");
				return ope;
			}else {
				Cliente cliente = servicioCliente.recuperaCliente(nombreDeUsuario, contrasenia);
				if(cliente != null) {
					System.out.println("Es cliente");
					return cliente;
				}else {
					System.out.println("No se encontró");
					return null;
				}
			}
		}
	}

	/*
	 * Description: Method who initializes operations principal window
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: Object usuario
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void iniciaPrincipalOperaciones(Object usuario) {
		controlOperaciones.inicia(this, usuario);
		
	}

	/*
	 * Description: Method who initializes clients principal window
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: Cliente cliente
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void iniciaPrincipalCliente(Cliente cliente) {
		controlCliente.inicia(this, cliente);
		
	}

	/*
	 * Description: Method who initializes User Story Agregar Usuario
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: Object usuario
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void iniciaAgregarUsuario(Object usuario) {
		controlAgregarUsuario.inicia(usuario);	
	}
}
