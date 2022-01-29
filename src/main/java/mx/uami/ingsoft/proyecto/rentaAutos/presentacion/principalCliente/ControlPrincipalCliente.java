package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;

@Component
@Controller
public class ControlPrincipalCliente {
	
	@Autowired
	private VistaPrincipalCliente ventana;

	public void inicia(Cliente cliente) {
		ventana.muestra(this, cliente);
		
	}

}
