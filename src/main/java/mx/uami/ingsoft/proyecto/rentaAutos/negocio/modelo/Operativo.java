/*
 * SourceFile: Operativo
 *  Description: Class who extends from Usuario and manages the actions and attributes
 * 				of the entity Operativo
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
public class Operativo extends Usuario {

/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdOperativo;*/
	
	@OneToMany(mappedBy = "operativo", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Contacto> contactos = new ArrayList<>();
	
	@OneToMany(mappedBy = "operativo", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Notificacion> notificaciones;
}
