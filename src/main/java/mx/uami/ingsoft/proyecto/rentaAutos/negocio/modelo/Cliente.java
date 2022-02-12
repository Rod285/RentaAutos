/*
 * SourceFile: Cliente
 *  Description: Class who extends from Usuario and manages the actions and attributes
 * 				of the entity Cliente
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario {
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER
				, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> pedidos;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Notificacion> notificaciones;
}
