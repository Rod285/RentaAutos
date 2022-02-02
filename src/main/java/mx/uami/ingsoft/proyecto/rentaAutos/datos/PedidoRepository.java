package mx.uami.ingsoft.proyecto.rentaAutos.datos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


}
