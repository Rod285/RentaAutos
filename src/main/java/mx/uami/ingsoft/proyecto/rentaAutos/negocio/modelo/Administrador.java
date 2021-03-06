/*
 * SourceFile: Administrador
 * Description: Class who extends from Usuario and manages the actions and attributes
 * 				of the entity Administrador
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Administrador extends Usuario {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdAdmin;*/
	
	@OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pedido> pedidos = new ArrayList<>();
	
	@OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Notificacion> notificaciones = new ArrayList<>();
}
