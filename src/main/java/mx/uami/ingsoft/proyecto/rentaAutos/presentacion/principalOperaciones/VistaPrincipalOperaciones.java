/*
 * SourceFile: VistaPrincipalOperaciones
 * Description: Class who manages the rendering of the principal view for Operations staff
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalOperaciones;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Administrador;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Operativo;
import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.ModeloCalendario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@SuppressWarnings("serial")
@Component
public class VistaPrincipalOperaciones extends JFrame {

	private ControlPrincipalOperaciones control;
	private Object usuario;
	private JPanel panelAdministradorAgregar;
	private JPanel panelOperativoAgregar;
	private JTable tablaCalendario;
	private JTextField textFieldMes;
	private JLabel lblUsuario;
	private JTable table;
	private JPanel panelConsultar;
	
	public VistaPrincipalOperaciones() {
		setBounds(100, 5, 660, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("backend.png"))
						.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(10, 10, 120, 100);
		getContentPane().add(lblLogo);
		
		JLabel lblBienvenida = new JLabel("Bienvenido: ");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setBounds(180, 40, 150, 40);
		getContentPane().add(lblBienvenida);
		
		lblUsuario = new JLabel();
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsuario.setBounds(330, 40, 150, 40);
		getContentPane().add(lblUsuario);
		
		panelAdministradorAgregar = new JPanel();
		panelAdministradorAgregar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)
											, 1, true), "Agregar", TitledBorder.LEFT
											, TitledBorder.TOP, null, null));
		panelAdministradorAgregar.setBounds(188, 98, 237, 60);
		panelAdministradorAgregar.setLayout(null);
		
		JButton btnAgregarOperativo = new JButton("Operativo");
		btnAgregarOperativo.setBounds(20, 20, 90, 25);
		panelAdministradorAgregar.add(btnAgregarOperativo);
		
		JButton btnAgregarCliente = new JButton("Cliente");
		btnAgregarCliente.setBounds(125, 20, 90, 25);
		panelAdministradorAgregar.add(btnAgregarCliente);
				
		panelOperativoAgregar = new JPanel();
		panelOperativoAgregar.setBorder(new TitledBorder(new LineBorder(
										new Color(0, 0, 0), 1, true), "Agregar"
										, TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelOperativoAgregar.setBounds(188, 98, 237, 60);
		panelOperativoAgregar.setLayout(null);
		
		JButton btnAgregarContacto = new JButton("Contacto");
		btnAgregarContacto.setBounds(20, 20, 90, 25);
		panelOperativoAgregar.add(btnAgregarContacto);
		
		JButton btnAgregarVehiculo = new JButton("Vehiculo");
		btnAgregarVehiculo.setBounds(125, 20, 90, 25);
		panelOperativoAgregar.add(btnAgregarVehiculo);
		
		panelConsultar = new JPanel();
		panelConsultar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)
											, 1, true), "Consultar", TitledBorder.LEFT
											, TitledBorder.TOP, null, null));
		panelConsultar.setBounds(421, 98, 170, 60);
		panelConsultar.setLayout(null);
		
		JButton btnConsultaProyecto = new JButton("Proyecto");
		btnConsultaProyecto.setBounds(15, 20, 100, 25);
		panelConsultar.add(btnConsultaProyecto);
		
		JButton btnConsultaNotificaciones = new JButton();
		btnConsultaNotificaciones.setIcon(new ImageIcon(new ImageIcon(getClass()
									.getResource("bell.png")).getImage()
									.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		btnConsultaNotificaciones.setBounds(127, 20, 25, 25);
		btnConsultaNotificaciones.setToolTipText("Presione para ver notificaciones");
		panelConsultar.add(btnConsultaNotificaciones);
		getContentPane().add(panelConsultar);
		
		JButton btnCerrarSesion = new JButton();
		btnCerrarSesion.setIcon(new ImageIcon(new ImageIcon(getClass()
								.getResource("logOut.png")).getImage()
								.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		btnCerrarSesion.setBounds(58, 358, 30, 30);
		btnCerrarSesion.setToolTipText("Presione para cerrar sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccion = 0;
				seleccion = dialogoConfirmaCerrarSesion();
				if(seleccion == 0) {
					if(usuario.getClass().equals(Administrador.class)) {
						panelAdministradorAgregar.setVisible(false);
					}else {
						panelOperativoAgregar.setVisible(false);
					}
					control.volverAIniciarSesion();
					setVisible(false);
				}
			}
			
		});
		getContentPane().add(btnCerrarSesion);
		
		textFieldMes = new JTextField();
		textFieldMes.setEditable(false);
		textFieldMes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMes.setBounds(10, 155, 126, 25);
		getContentPane().add(textFieldMes);
		textFieldMes.setColumns(10);
		
		JScrollPane panelCalendario = new JScrollPane();
		panelCalendario.setBounds(10, 180, 126, 148);
		
		tablaCalendario = new JTable();
		tablaCalendario.setRowHeight(25);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tablaCalendario.setDefaultRenderer(String.class, centerRenderer);
		tablaCalendario.setDefaultRenderer(Integer.class, centerRenderer);
		panelCalendario.setViewportView(tablaCalendario);
		getContentPane().add(panelCalendario);
		
		JScrollPane panelNotificaciones = new JScrollPane();
		panelNotificaciones.setBounds(190, 155, 400, 173);
		getContentPane().add(panelNotificaciones);
		
		table = new JTable();
		panelNotificaciones.setViewportView(table);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.setBounds(240, 360, 100, 25);
		getContentPane().add(btnAgenda);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(440, 360, 100, 25);
		getContentPane().add(btnBorrar);
		
	}

	/*
	 * Description: Method that initializes components and the principal view for operative members
	 * 				of the staff 
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: ControlPrincipalOperaciones controlPrincipalOperaciones, Object usuario
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void muestra(ControlPrincipalOperaciones controlPrincipalOperaciones, Object usuario) {
		this.control = controlPrincipalOperaciones;
		this.usuario = usuario;
		
		textFieldMes.setText(LocalDate.now().getMonth().getDisplayName(
							TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
		
		ModeloCalendario modeloCalendario = new ModeloCalendario();
		tablaCalendario.setModel(modeloCalendario);
		
		if(usuario.getClass().equals(Administrador.class)) {
			setTitle("Principal Administrador");
			lblUsuario.setText(((Administrador)usuario).getNombreUsuario());
			getContentPane().add(panelAdministradorAgregar);
			panelAdministradorAgregar.setVisible(true);
		}else {
			setTitle("Principal Operativo");
			lblUsuario.setText(((Operativo)usuario).getNombreUsuario());
			getContentPane().add(panelOperativoAgregar);
			panelOperativoAgregar.setVisible(true);
		}
		
		setVisible(true);
	}
	
	/*
	 * Description: Method that shows message to confirm or cancel to log out
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: int
	 * Date: 12/02/2022
	 */
	private int dialogoConfirmaCerrarSesion() {
		int seleccion = JOptionPane.showOptionDialog(null, "¿Desea cerrar sesión?"
													, "Cerrar sesión", 0, 3, null
													, new Object[] {"SI", "NO"}, null);
		return seleccion;
	}
}
