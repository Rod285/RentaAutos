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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPedido;
	
	@OneToMany(mappedBy = "pedido")
	private List<PedidoVehiculo> pedidoVehiculos = new ArrayList<>();
}
