package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdVehiculo;
	
	private String tipo;
	private String modelo;
	private int anio;
	private int costo;
	private String foto;
	private Boolean disponibilidad;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<PedidoVehiculo> pedidoVehiculos = new ArrayList<>();	
}
