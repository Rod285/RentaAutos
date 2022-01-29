package mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdNotificacion;
	
	private String descripcion;
	private LocalDate fecha;
}
