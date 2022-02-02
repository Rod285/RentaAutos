package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	Administrador findByNombreUsuario(String nombreDeUsuario);

}
