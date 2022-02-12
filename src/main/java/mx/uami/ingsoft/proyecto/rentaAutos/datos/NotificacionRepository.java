/*
 * SourceFile: ContactoRepository
 * Description: Class who manages the CRUD for the entity Contacto
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}
