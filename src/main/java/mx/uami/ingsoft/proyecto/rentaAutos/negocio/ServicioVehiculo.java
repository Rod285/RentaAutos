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
