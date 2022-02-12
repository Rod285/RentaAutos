/*
 * SourceFile: VistaAgregarUsuario
 * Description: Class who manages the rendering of the view for User Story Agregar Usuario
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.agregarUsuario;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")
@Component
public class VistaAgregarUsuario extends JFrame{
	
	static final int MAX_DIAS_MES = 31;
	static final int ANIO_MIN = 1900;
	static final int ANIO_MAX = LocalDate.now().getYear();
	static final int MAX_MESES = 12;

	private JLabel lblTipoUsuario;
	private ControlAgregarUsuario control;
	private Object usuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JTextField textFieldContrasenia;
	private JTextField textFieldConfirmaContrasenia;
	private JTextField textFieldTelefono;
	private JTextField textField;
	private JComboBox<Integer> comboBoxDia;
	private JComboBox<String> comboBoxMes;
	private JComboBox<Integer> comboBoxAnio;
	
	public VistaAgregarUsuario() {
		setBounds(100, 5, 500, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNuevo = new JLabel("Agregando nuevo ");
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNuevo.setBounds(130, 10, 115, 25);
		getContentPane().add(lblNuevo);
		
		lblTipoUsuario = new JLabel();
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoUsuario.setBounds(240, 10, 105, 25);
		getContentPane().add(lblTipoUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(90, 60, 120, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre(s)");
		lblNombre.setBounds(25, 60, 60, 25);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido(s)");
		lblApellido.setBounds(245, 60, 60, 25);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(310, 60, 150, 25);
		getContentPane().add(textFieldApellido);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electrónico");
		lblCorreoElectrnico.setBounds(25, 220, 120, 25);
		getContentPane().add(lblCorreoElectrnico);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(145, 220, 200, 25);
		getContentPane().add(textFieldCorreo);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(25, 310, 120, 25);
		getContentPane().add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setColumns(10);
		textFieldContrasenia.setBounds(145, 310, 200, 25);
		getContentPane().add(textFieldContrasenia);
		
		JLabel lblConfirmaContrasenia = new JLabel("Confirma contraseña");
		lblConfirmaContrasenia.setBounds(25, 355, 120, 25);
		getContentPane().add(lblConfirmaContrasenia);
		
		textFieldConfirmaContrasenia = new JTextField();
		textFieldConfirmaContrasenia.setColumns(10);
		textFieldConfirmaContrasenia.setBounds(145, 355, 200, 25);
		getContentPane().add(textFieldConfirmaContrasenia);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(25, 265, 120, 25);
		getContentPane().add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(145, 265, 200, 25);
		getContentPane().add(textFieldTelefono);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario");
		lblNombreUsuario.setBounds(25, 175, 120, 25);
		getContentPane().add(lblNombreUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 175, 200, 25);
		getContentPane().add(textField);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Edad"
						, TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(30, 105, 420, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBoxDia = new JComboBox<Integer>();
		comboBoxDia.setBounds(60, 15, 50, 25);
		panel.add(comboBoxDia);
		
		JLabel lblDia = new JLabel("Día");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setBounds(10, 15, 50, 25);
		panel.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setBounds(130, 15, 50, 25);
		panel.add(lblMes);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(180, 15, 80, 25);
		panel.add(comboBoxMes);
		
		comboBoxAnio = new JComboBox<Integer>();
		comboBoxAnio.setBounds(330, 15, 80, 25);
		panel.add(comboBoxAnio);
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnio.setBounds(280, 15, 50, 25);
		panel.add(lblAnio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(40, 405, 100, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(190, 405, 100, 25);
		getContentPane().add(btnLimpiar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(340, 405, 100, 25);
		getContentPane().add(btnCancelar);
	}

	/*
	 * Description: Method who initializes components and the view of User Story Agregar Usuario
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: ControlAgregarUsuario controlAgregarUsuario, Object usuario
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void muestra(ControlAgregarUsuario controlAgregarUsuario, Object usuario) {
		this.control = controlAgregarUsuario;
		this.usuario = usuario;
		
		lblTipoUsuario.setText(usuario.getClass().getSimpleName());
		DefaultComboBoxModel<Integer> modeloDias = new DefaultComboBoxModel<Integer>();
		DefaultComboBoxModel<Integer> modeloAnio = new DefaultComboBoxModel<Integer>();
		DefaultComboBoxModel<String> modeloMes = new DefaultComboBoxModel<String>();
		
		for(int i = 1; i <= MAX_DIAS_MES; i++) {
			modeloDias.addElement(i);
		}
		
		comboBoxDia.setModel(modeloDias);
		
		for(int i = ANIO_MAX; i >= ANIO_MIN; i--) {
			modeloAnio.addElement(i);
		}
		
		comboBoxAnio.setModel(modeloAnio);
		
		for(int i = 1; i <= MAX_MESES; i++) {
			modeloMes.addElement(LocalDate.of(i, i, i).getMonth().getDisplayName(
								TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
		}
		
		comboBoxMes.setModel(modeloMes);
		
		setVisible(true);
	}
}
