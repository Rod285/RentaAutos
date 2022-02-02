package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PedidoVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPedidoVehiculo;
	
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "idVehiculo")
	private Vehiculo vehiculo;
}
