package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.AdministradorRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;

@Component
@Service
public class ServicioAdministrador {
	
	@Autowired
	private AdministradorRepository administradorRepository;

	public Administrador recuperaAdministrador(String nombreDeUsuario, String contrasenia) {
		Administrador admin = administradorRepository.findByNombreUsuario(nombreDeUsuario);
		System.out.println("Contraseña introducida: " + contrasenia);
		if(admin != null) {
			System.out.println("Usuario: " + admin.getNombreUsuario());
			System.out.println("contraseña: " + admin.getContrasenia());
			if(contrasenia.equals(admin.getContrasenia())) {
				return admin;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
