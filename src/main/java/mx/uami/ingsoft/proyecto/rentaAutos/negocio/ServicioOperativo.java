package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.OperativoRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;

@Component
@Service
public class ServicioOperativo {

	@Autowired
	private OperativoRepository operativoRepository;
	
	public Operativo recuperaOperativo(String nombreDeUsuario, String contrasenia) {
		Operativo operativo = operativoRepository.findByNombreUsuario(nombreDeUsuario);
		if(operativo != null) {
			if(operativo.getContrasenia().equals(contrasenia)) {
				return operativo;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
