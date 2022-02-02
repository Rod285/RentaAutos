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
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(targetEntity = Contacto.class)
	@JoinColumn(name = "idContacto")
	private Contacto contacto;
	
	@OneToMany(mappedBy = "vehiculo", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<PedidoVehiculo> pedidoVehiculos;	
}
