package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalOperaciones;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
@Component
public class VistaPrincipalOperaciones extends JFrame {

	private ControlPrincipalOperaciones control;
	private Object usuario;
	private JPanel panelAdministradorAgregar;
	private JPanel panelOperativoAgregar;

	public VistaPrincipalOperaciones() {
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelAdministradorAgregar = new JPanel();
		panelAdministradorAgregar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Agregar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelAdministradorAgregar.setBounds(10, 10, 245, 60);
		panelAdministradorAgregar.setLayout(null);
		
		JButton btnAgregarOperativo = new JButton("Operativo");
		btnAgregarOperativo.setBounds(15, 20, 100, 25);
		panelAdministradorAgregar.add(btnAgregarOperativo);
		
		JButton btnAgregarCliente = new JButton("Cliente");
		btnAgregarCliente.setBounds(130, 20, 100, 25);
		panelAdministradorAgregar.add(btnAgregarCliente);
		
		panelOperativoAgregar = new JPanel();
		panelOperativoAgregar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Agregar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelOperativoAgregar.setBounds(10, 10, 200, 60);
		panelOperativoAgregar.setLayout(null);
		
		JButton btnAgregarContacto = new JButton("Contacto");
		btnAgregarContacto.setBounds(50, 20, 100, 25);
		panelOperativoAgregar.add(btnAgregarContacto);
		
	}
	
	public void muestra(ControlPrincipalOperaciones controlPrincipalOperaciones, Object usuario) {
		this.control = controlPrincipalOperaciones;
		this.usuario = usuario;
		
		if(usuario.getClass().equals(Administrador.class)) {
			setTitle("Principal Administrador");
			getContentPane().add(panelAdministradorAgregar);
		}else {
			setTitle("Principal Operativo");
			getContentPane().add(panelOperativoAgregar);
		}
		
		setVisible(true);
	}
}
