package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalOperaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioPedido;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Pedido;

@Component
@Controller
public class ControlPrincipalOperaciones {

	@Autowired
	private VistaPrincipalOperaciones ventana;
	
	@Autowired
	private ServicioPedido servicioPedido;

	public void inicia(Object usuario) {
		ventana.muestra(this, usuario);
		
	}

}
