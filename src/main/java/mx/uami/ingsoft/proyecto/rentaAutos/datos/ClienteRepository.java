package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByNombreUsuario(String nombreDeUsuario);

}
