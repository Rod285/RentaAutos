package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalCliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.ServicioVehiculo;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Vehiculo;

@Slf4j
@Component
@Controller
public class ControlPrincipalCliente {
	static final String CLASICO = "Clasico",
						LUJO = "Lujo",
						DEPORTIVO = "Deportivo",
						CARGA = "Carga";		  
	
	@Autowired
	private VistaPrincipalCliente ventana;
	
	@Autowired
	private ServicioVehiculo servicioVehiculo;

	public void inicia(Cliente cliente) {
		List<Vehiculo> listaClasicos = servicioVehiculo.recuperaVehiculosPorTipo(CLASICO);
		if(listaClasicos == null) {
			ventana.muestraDialogoListaVacía();
		}
		log.info("en control");
		log.info("modelo: " + listaClasicos.get(0).getModelo());
		List<Vehiculo> listaLujo = servicioVehiculo.recuperaVehiculosPorTipo(LUJO);
		List<Vehiculo> listaDeportivos = servicioVehiculo.recuperaVehiculosPorTipo(DEPORTIVO);
		List<Vehiculo> listaCarga = servicioVehiculo.recuperaVehiculosPorTipo(CARGA);
		
		ventana.muestra(this, cliente, listaClasicos, listaLujo, listaDeportivos, listaCarga);
	}

}
