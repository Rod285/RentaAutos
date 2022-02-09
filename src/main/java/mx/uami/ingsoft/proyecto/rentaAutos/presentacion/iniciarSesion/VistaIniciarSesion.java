package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.iniciarSesion;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;

@SuppressWarnings("serial")
@Component
public class VistaIniciarSesion extends JFrame{
	
	private ControlIniciarSesion control;
	private JTextField textFieldNombreUsuario;
	private JPasswordField passwordField;
	JCheckBox chkboxClienteNuevo;
	private String nombreDeUsuario;
	private String contrasenia;
	
	public VistaIniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(null);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setBounds(185, 90, 150, 25);
		getContentPane().add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(38, 90, 120, 25);
		getContentPane().add(lblNombreDeUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(38, 140, 120, 25);
		getContentPane().add(lblContrasenia);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			boolean bandera = false;
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				nombreDeUsuario = textFieldNombreUsuario.getText();
				contrasenia = passwordField.getText();
				if(!chkboxClienteNuevo.isSelected()) {
					bandera = validaCampos(nombreDeUsuario, contrasenia);
					if(bandera == true) {
						Object usuario = control.validaUsuario(nombreDeUsuario, contrasenia);
						if(usuario == null) {
							muestraDialogoErrorAlIniciarSesion();
						}else if(usuario.getClass().equals(Cliente.class)) {
							textFieldNombreUsuario.setText("");
							passwordField.setText("");
							control.iniciaPrincipalCliente((Cliente) usuario);
							setVisible(false);
						}else {
							textFieldNombreUsuario.setText("");
							passwordField.setText("");
							control.iniciaPrincipalOperaciones(usuario);
							setVisible(false);
						}
					}
				}else {
					textFieldNombreUsuario.setText("");
					passwordField.setText("");
					Cliente cliente = new Cliente();
					control.iniciaAgregarUsuario((Object) cliente);
					setVisible(false);
				}
			}
		});
		btnAceptar.setBounds(38, 225, 90, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(245, 225, 90, 25);
		getContentPane().add(btnCancelar);
		
		chkboxClienteNuevo = new JCheckBox("Registro como \r\ncliente nuevo");
		chkboxClienteNuevo.setToolTipText("Seleccione esta casilla si no cuenta con una cuenta de usuario \n y desea crear una");
		chkboxClienteNuevo.setBackground(Color.WHITE);
		chkboxClienteNuevo.setBounds(34, 185, 190, 25);
		getContentPane().add(chkboxClienteNuevo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 140, 150, 25);
		getContentPane().add(passwordField);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(40, 15, 60, 60);
		getContentPane().add(lblLogo);
		
		JLabel lblTitulo = new JLabel("Inicio de Sesión");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(150, 31, 150, 25);
		getContentPane().add(lblTitulo);
	}
	
	public void muestra(ControlIniciarSesion controlIniciarSesion) {
		this.control = controlIniciarSesion;
		setVisible(true);
	}
	
	public boolean validaCampos(String nombreDeUsuario, String contrasenia) {
		if((nombreDeUsuario == null || contrasenia == null) || (nombreDeUsuario.equals("") || contrasenia.equals(""))){
			muestraDialogoCamposVacios();
			return false;
		}else {
			return true;
		}
	}

	private void muestraDialogoErrorAlIniciarSesion() {
		JOptionPane.showMessageDialog(null, "El usuario no fue encontrado, por favor revise el nombre de usuario y contraseña."
				+ " Si no se encuentra registrado, seleccione la casilla Registrar como cliente nuevo y a continuación de click en aceptar");	
	}

	private void muestraDialogoCamposVacios() {
		JOptionPane.showMessageDialog(null, "Los campos nombre de usuario y/o contraseña no deben estar vacios");
	}
}
