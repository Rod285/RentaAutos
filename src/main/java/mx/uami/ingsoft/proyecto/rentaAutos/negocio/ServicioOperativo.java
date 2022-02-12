/*
 * SourceFile: ServicioOperativo
 * Description: Class who manages the actions and rules of business for the entity Operativo
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
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
	
	/*
	 * Description: Method who calls operativoRepository to find an operator by opetarive's name
	 * 				and validates the its password
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario, String contrasenia
	 * Return Value: Administrador
	 * Date: 12/02/2022
	 */
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
