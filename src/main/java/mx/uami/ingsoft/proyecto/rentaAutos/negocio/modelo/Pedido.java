package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.time.LocalDate;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPedido;
	
	private LocalDate fechaInicio;
	private LocalDate fechaEntrega;
	private double monto;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PedidoVehiculo> pedidoVehiculos = new ArrayList<>();
	
	@ManyToOne(targetEntity = Administrador.class)
	@JoinColumn(name = "idAdministrador")
	private Administrador administrador;
	
	@ManyToOne(targetEntity = Cliente.class)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
}
