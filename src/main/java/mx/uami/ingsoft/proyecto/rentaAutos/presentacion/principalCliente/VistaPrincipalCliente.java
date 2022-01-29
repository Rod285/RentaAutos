package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalCliente;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;

@SuppressWarnings("serial")
@Component
public class VistaPrincipalCliente extends JFrame{

	private ControlPrincipalCliente control;
	private Cliente cliente;

	public VistaPrincipalCliente() {
		setTitle("Principal Cliente");
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void muestra(ControlPrincipalCliente controlPrincipalCliente, Cliente cliente) {
		this.control = controlPrincipalCliente;
		this.cliente = cliente;
		
		setVisible(true);
	}

}
