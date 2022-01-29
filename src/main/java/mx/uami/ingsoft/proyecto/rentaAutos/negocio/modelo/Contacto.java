package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdContacto;

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	@OneToMany(targetEntity = Vehiculo.class,  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idVehiculo")
	private List<Vehiculo> vehiculos = new ArrayList<>();
}
