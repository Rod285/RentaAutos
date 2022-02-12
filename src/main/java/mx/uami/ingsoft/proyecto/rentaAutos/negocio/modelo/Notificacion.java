/*
 * SourceFile: Notificacion
 * Description: Class who manages the actions and attributes of the entity Notificacion
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdNotificacion;
	
	private String descripcion;
	private LocalDate fecha;
	
	@ManyToOne(targetEntity = Administrador.class)
	@JoinColumn(name = "idAdministrador")
	private Administrador administrador;
	
	@ManyToOne(targetEntity = Cliente.class)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@ManyToOne(targetEntity = Operativo.class)
	@JoinColumn(name = "idOperativo")
	private Operativo operativo;
}
