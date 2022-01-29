package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.ClienteRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;

@Component
@Service
public class ServicioCliente {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente recuperaCliente(String nombreDeUsuario, String contrasenia) {
		Cliente cliente = clienteRepository.findByNombreUsuario(nombreDeUsuario);
		return cliente;
	}

}
