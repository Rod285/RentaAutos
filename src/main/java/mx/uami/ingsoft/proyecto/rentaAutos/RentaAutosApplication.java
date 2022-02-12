/*
 * SourceFile: RentaAutosApplication
 * Description: Class who launches the application
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.iniciarSesion.ControlIniciarSesion;

@SpringBootApplication
public class RentaAutosApplication {

	@Autowired
	private ControlIniciarSesion controlIniciarSesion;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(RentaAutosApplication.class);

		builder.headless(false);

		builder.run(args);
	}
	
	/*
	 * Description: Method who initializes the User Story Iniciar Sesión
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	@PostConstruct
	public void inicia() {
		
		controlIniciarSesion.inicia();
	}

}
