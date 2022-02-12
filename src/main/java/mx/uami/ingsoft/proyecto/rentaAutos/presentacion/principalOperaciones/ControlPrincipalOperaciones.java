/*
 * SourceFile: ControlPrincipalOperaciones
 * Description: Class who manages the interaction flow of users type Operativo and
 * 				Administrador activities
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalOperaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioPedido;
import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.iniciarSesion.ControlIniciarSesion;

@Component
@Controller
public class ControlPrincipalOperaciones {

	@Autowired
	private VistaPrincipalOperaciones ventana;
	
	@Autowired
	private ServicioPedido servicioPedido;
	
	private ControlIniciarSesion controlIniciarSesion;

	/*
	 * Description: Method that initializes and manage the flow of user's interaction 
	 * 				with operative principal view.
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: ControlIniciarSesion controlIniciarSesion, Object usuario
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void inicia(ControlIniciarSesion controlIniciarSesion, Object usuario) {
		this.controlIniciarSesion = controlIniciarSesion;
		ventana.muestra(this, usuario);
	}

	/*
	 * Description: Method that initializes again User Story Iniciar Sesión, when a user log out
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void volverAIniciarSesion() {
		controlIniciarSesion.inicia();
	}

}
