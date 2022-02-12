/*
 * SourceFile: ServicioVehiculo
 * Description: Class who manages the actions and rules of business for the entity Vehiculo
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uami.ingsoft.proyecto.rentaAutos.datos.VehiculoRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Vehiculo;

@Slf4j
@Component
@Service
public class ServicioVehiculo {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;

	/*
	 * Description: Method who calls vehiculoRepository to find all vehicles of a kind
	 * 				and validates if the list is empty, if the list is empty returns null
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String tipo
	 * Return Value: List<Vehiculos>, null
	 * Date: 12/02/2022
	 */
	public List<Vehiculo> recuperaVehiculosPorTipo(String tipo) {
		List<Vehiculo> listaRecuperada = new ArrayList<>();
		listaRecuperada = vehiculoRepository.findByTipo(tipo);
		if(listaRecuperada.size() > 0) {
			log.info("En servicio");
			log.info("tamaño lista: " + listaRecuperada.size());
			log.info("tipo: " + listaRecuperada.get(0).getTipo());
			log.info("modelo: " + listaRecuperada.get(0).getModelo());
			return listaRecuperada;
		}else {
			return null;
		}
	}

}
