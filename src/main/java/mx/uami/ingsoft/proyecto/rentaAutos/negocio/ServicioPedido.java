package mx.uami.ingsoft.proyecto.rentaAutos.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.uami.ingsoft.proyecto.rentaAutos.datos.PedidoRepository;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Pedido;

@Component
@Service
public class ServicioPedido {
	
	@Autowired
	private PedidoRepository pedidoRepository;

}
