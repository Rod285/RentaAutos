/*
 * SourceFile: ServicioPedido
 * Description: Class who manages the actions and rules of business for the entity Pedido
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.PedidoRepository;

@Component
@Service
public class ServicioPedido {
	
	@Autowired
	private PedidoRepository pedidoRepository;

}
