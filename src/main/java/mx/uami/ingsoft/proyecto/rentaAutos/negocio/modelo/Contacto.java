/*
 * SourceFile: Contacto
 * Description: Class who manages the actions and attributes of the entity Contacto
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

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
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContacto;

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	@ManyToOne(targetEntity = Operativo.class)
	@JoinColumn(name = "idOperativo")
	private Operativo operativo;
	
	@OneToMany(mappedBy = "contacto",  fetch = FetchType.EAGER
				, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehiculo> vehiculos;
}
