/*
 * SourceFile: VistaIniciarSesion
 * Description: Class who manages the rendering of the User Story Iniciar Sesión
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.iniciarSesion;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

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
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("\\backend.png"))
						.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(40, 15, 60, 60);
		getContentPane().add(lblLogo);
		
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
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccion = 0;
				seleccion = dialogoConfirmacionSalir();
				if(seleccion == 0) {
					setVisible(false);
					System.exit(0);
				}
			}
			
		});
		btnSalir.setBounds(245, 225, 90, 25);
		getContentPane().add(btnSalir);
		
		chkboxClienteNuevo = new JCheckBox("Registro como cliente nuevo");
		chkboxClienteNuevo.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccion = 0;
				
				if(chkboxClienteNuevo.isSelected()) {
					if(!textFieldNombreUsuario.getText().equals("") 
						|| !passwordField.getText().equals("")) {
						
						seleccion = dialogoConfirmarSeleccionCasilla();
					}
					if(seleccion == 0) {
						textFieldNombreUsuario.setText("");
						textFieldNombreUsuario.setEnabled(false);
						passwordField.setText("");
						passwordField.setEnabled(false);
					}else {
						chkboxClienteNuevo.setSelected(false);
						textFieldNombreUsuario.setEnabled(true);
						passwordField.setEnabled(true);
					}
				}else {
					textFieldNombreUsuario.setEnabled(true);
					passwordField.setEnabled(true);
				}	
			}
		});
		chkboxClienteNuevo.setToolTipText("Seleccione esta casilla si no posee una cuenta"
											+ " de usuario y desea crear una");
		chkboxClienteNuevo.setBackground(Color.WHITE);
		chkboxClienteNuevo.setBounds(34, 185, 190, 25);
		getContentPane().add(chkboxClienteNuevo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 140, 150, 25);
		getContentPane().add(passwordField);
		
		JLabel lblTitulo = new JLabel("Inicio de Sesión");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(150, 31, 150, 25);
		getContentPane().add(lblTitulo);
	}

	/*
	 * Description: Method who initializes the view for User Story Iniciar Sesión
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: ControlIniciarSesion controlIniciarSesion
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void muestra(ControlIniciarSesion controlIniciarSesion) {
		this.control = controlIniciarSesion;
		setVisible(true);
	}
	
	/*
	 * Description: Method that validates if the text fields user´s name and password are not empty
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String nombreDeUsuario, String contrasenia
	 * Return Value: boolean
	 * Date: 12/02/2022
	 */
	public boolean validaCampos(String nombreDeUsuario, String contrasenia) {
		if((nombreDeUsuario == null || contrasenia == null) || (nombreDeUsuario.equals("") 
			|| contrasenia.equals(""))){
			
			muestraDialogoCamposVacios();
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * Description: Method who shows message to confirm or cancel to leave the application
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: int
	 * Date: 12/02/2022
	 */
	private int dialogoConfirmacionSalir() {
		int seleccion = JOptionPane.showOptionDialog(null, "¿Desea salir?", "Salir", 0, 3,
													null, new Object[] {"SI", "NO"}, null);
		return seleccion;
	}
	
	/*
	 * Description: Method that shows a message which informs the user has not found 
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	private void muestraDialogoErrorAlIniciarSesion() {
		JOptionPane.showMessageDialog(null, "El usuario no fue encontrado, por favor revise"
										+ " el nombre de usuario y contraseña.");	
	}

	/*
	 * Description: Method that shows a message which informs user that fields are empty 
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	private void muestraDialogoCamposVacios() {
		JOptionPane.showMessageDialog(null, "Los campos nombre de usuario y/o "
										+ "contraseña no deben estar vacios");
	}
	
	/*
	 * Description: Method that shows a message which informs the user selection of checkbox
	 * 				will erase the information in the text fields
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: int
	 * Date: 12/02/2022
	 */
	private int dialogoConfirmarSeleccionCasilla() {
		int seleccion = JOptionPane.showOptionDialog(null, "Se borraran datos en formulario"
														, "Crear Cuenta Nueva",	0, 3, null
														, new Object[] {"SI", "NO"}, null);
		return seleccion;
	}
}
