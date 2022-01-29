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
	private VistaAgregarUsuario vista;
}
