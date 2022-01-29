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
public class Operativo extends Usuario {

/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdOperativo;*/
	
	@OneToMany(targetEntity = Contacto.class,  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idOperativo")
	private List<PedidoVehiculo> contactos = new ArrayList<>();
	
	@OneToMany(targetEntity = Notificacion.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idOperativo")
	private List<Notificacion> notificaciones = new ArrayList<>();
}
