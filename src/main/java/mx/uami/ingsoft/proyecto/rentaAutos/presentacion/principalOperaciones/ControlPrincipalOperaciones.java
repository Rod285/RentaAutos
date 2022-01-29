package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalOperaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class ControlPrincipalOperaciones {

	@Autowired
	private VistaPrincipalOperaciones ventana;
	
	public void inicia(Object usuario) {
		ventana.muestra(this, usuario);
		
	}

}
