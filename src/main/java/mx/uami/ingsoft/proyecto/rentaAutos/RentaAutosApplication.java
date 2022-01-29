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
	
	@PostConstruct
	public void inicia() {
		
	//	initializesBD();
		
		controlIniciarSesion.inicia();
	}

}
