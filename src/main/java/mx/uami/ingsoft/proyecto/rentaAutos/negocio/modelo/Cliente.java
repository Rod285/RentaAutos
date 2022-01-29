package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario {
	
/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCliente;*/

	@OneToMany(targetEntity = Pedido.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idCliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	@OneToMany(targetEntity = Notificacion.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idCliente")
	private List<Notificacion> notificaciones = new ArrayList<>();
}
