/*
 * SourceFile: Usuario
 * Description: Superclass who manages the actions and attributes of the entity Usuario
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String edad;	
	private String telefono;
	private String correo;
	private String contrasenia;
}
