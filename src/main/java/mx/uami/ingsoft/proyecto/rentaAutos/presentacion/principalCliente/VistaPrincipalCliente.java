/*
 * SourceFile: VistaPrincipalCliente
 * Description: Class who manages the rendering of the principal view for clients
 * Author: Mejía Velázquez José Rodrigo
 * Date: 12/02/2022
 */
package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalCliente;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Vehiculo;
import mx.uami.ingsoft.proyecto.rentaAutos.presentacion.ModeloCalendario;

import javax.swing.JTextField;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

@Slf4j
@SuppressWarnings("serial")
@Component
public class VistaPrincipalCliente extends JFrame{

	private ControlPrincipalCliente control;
	private Cliente cliente;
	private List<Vehiculo> listaPedido;
	private JComboBox<String> comboBoxSeleccion;
	private JTextField textFieldBusqueda;
	private JLabel lblCliente;
	private JTable tablaCalendario;
	private JLabel lblFoto;
	private JTextField textFieldModelo;
	private JButton btnAgregarAPedido;
	private JButton btnEspecificaciones;
	private JButton btnVehiculoAnterior;
	private JButton btnVehiculoSiguiente;
	private JTextField textFieldMes;
	private List<Vehiculo> listaClasicos;
	private List<Vehiculo> listaLujo;
	private List<Vehiculo> listaDeportivos;
	private List<Vehiculo> listaCarga;
	private int seleccion;
	private int indice;

	public VistaPrincipalCliente() {
		setTitle("Principal Cliente");
		setBounds(100, 5, 660, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setForeground(Color.LIGHT_GRAY);
		textFieldBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldBusqueda.setText("Buscar");
		textFieldBusqueda.setBounds(485, 30, 150, 25);
		getContentPane().add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		
		JButton btnIrAPedido = new JButton("Ir a pedido");
		btnIrAPedido.setBounds(485, 70, 100, 25);
		getContentPane().add(btnIrAPedido);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(new ImageIcon(getClass()
						.getResource("\\fotos\\backend.png")).getImage()
						.getScaledInstance(120, 100, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(10, 10, 120, 100);
		getContentPane().add(lblLogo);
		
		JLabel lblBienvenida = new JLabel("Bienvenido: ");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setBounds(180, 40, 150, 40);
		getContentPane().add(lblBienvenida);
		
		lblCliente = new JLabel();
		lblCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCliente.setBounds(330, 40, 150, 40);
		getContentPane().add(lblCliente);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(220, 180, 320, 180);
		getContentPane().add(lblFoto);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setEditable(false);
		textFieldModelo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldModelo.setBounds(220, 155, 320, 25);
		getContentPane().add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		btnAgregarAPedido = new JButton("Agregar a pedido");
		btnAgregarAPedido.setBounds(240, 360, 140, 25);
		getContentPane().add(btnAgregarAPedido);
		
		btnEspecificaciones = new JButton("Especificaciones");
		btnEspecificaciones.setBounds(380, 360, 140, 25);
		getContentPane().add(btnEspecificaciones);
		
		btnVehiculoAnterior = new JButton("<");
		btnVehiculoAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("indice " + indice);
				switch(seleccion) {
				case 0: indice = muestraVehiculoAnterior(listaClasicos, indice);
						break;
				case 1: indice = muestraVehiculoAnterior(listaLujo, indice);
						break;
				case 2: indice = muestraVehiculoAnterior(listaDeportivos, indice);
						break;
				case 3: indice = muestraVehiculoAnterior(listaCarga, indice);
				break;
				}
			}
			
		});
		btnVehiculoAnterior.setBounds(190, 360, 50, 25);
		getContentPane().add(btnVehiculoAnterior);
		
		btnVehiculoSiguiente = new JButton(">");
		btnVehiculoSiguiente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("indice " + indice);
				switch(seleccion) {
					case 0: indice = muestraVehiculoSiguiente(listaClasicos, indice);
							break;
					case 1: indice = muestraVehiculoSiguiente(listaLujo, indice);
							break;
					case 2: indice = muestraVehiculoSiguiente(listaDeportivos, indice);
							break;
					case 3: indice = muestraVehiculoSiguiente(listaCarga, indice);
							break;
				}
			}
			
		});
		btnVehiculoSiguiente.setBounds(520, 360, 50, 25);
		getContentPane().add(btnVehiculoSiguiente);
		
		textFieldMes = new JTextField();
		textFieldMes.setEditable(false);
		textFieldMes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMes.setBounds(10, 155, 126, 25);
		getContentPane().add(textFieldMes);
		textFieldMes.setColumns(10);
		
		comboBoxSeleccion = new JComboBox<String>();
		comboBoxSeleccion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seleccion = comboBoxSeleccion.getSelectedIndex();
				indice = 0;
				switch(seleccion) {
				case 0	:cargaPrimerVehiculo(listaClasicos);
						break;
				case 1	:cargaPrimerVehiculo(listaLujo);
						break;
				case 2	:cargaPrimerVehiculo(listaDeportivos);
						break;
				case 3	:cargaPrimerVehiculo(listaCarga);
						break;
				}
			}
			
		});
		comboBoxSeleccion.setBounds(350, 130, 140, 25);
		getContentPane().add(comboBoxSeleccion);
		
		JLabel lblCategorias = new JLabel("Categorías");
		lblCategorias.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategorias.setBounds(270, 130, 80, 25);
		getContentPane().add(lblCategorias);
		
		JButton btnCerrarSesion = new JButton();
		btnCerrarSesion.setIcon(new ImageIcon(new ImageIcon(getClass()
								.getResource("\\fotos\\logOut.png")).getImage()
								.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		btnCerrarSesion.setBounds(58, 358, 30, 30);
		btnCerrarSesion.setToolTipText("Presione para cerrar sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int seleccion = 0;
				seleccion = dialogoConfirmaCerrarSesion();
				if(seleccion == 0) {
					control.volverAIniciarSesion();
					setVisible(false);
				}
			}
			
		});
		getContentPane().add(btnCerrarSesion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 126, 148);
		
		
		tablaCalendario = new JTable();
		tablaCalendario.setRowHeight(25);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tablaCalendario.setDefaultRenderer(String.class, centerRenderer);
		tablaCalendario.setDefaultRenderer(Integer.class, centerRenderer);
		scrollPane.setViewportView(tablaCalendario);
		getContentPane().add(scrollPane);
	}

	/*
	 * Description: Method that initializes components and the principal view for clients 
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: ControlPrincipalCliente controlPrincipalCliente, Cliente cliente
						, List<Vehiculo> listaClasicos, List<Vehiculo> listaLujo
						, List<Vehiculo> listaDeportivos, List<Vehiculo> listaCarga
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	public void muestra(ControlPrincipalCliente controlPrincipalCliente, Cliente cliente
						, List<Vehiculo> listaClasicos, List<Vehiculo> listaLujo
						, List<Vehiculo> listaDeportivos, List<Vehiculo> listaCarga) {
		this.control = controlPrincipalCliente;
		this.cliente = cliente;
		this.listaClasicos = listaClasicos;
		this.listaLujo = listaLujo;
		this.listaDeportivos = listaDeportivos;
		this.listaCarga = listaCarga;
		
		lblCliente.setText(cliente.getNombreUsuario());
		textFieldMes.setText(LocalDate.now().getMonth().getDisplayName(
							TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
		
		log.info("En vista");
		log.info("tamaño lista: " + listaClasicos.size());
		log.info(listaClasicos.get(0).getFoto());
		
		comboBoxSeleccion.setModel(new DefaultComboBoxModel<String>(
									new String[] {"Clásico", "Lujo", "Deportivo", "Carga"}));
		
		cargaPrimerVehiculo(listaClasicos);
		
		indice = 0;
		ModeloCalendario modeloCalendario = new ModeloCalendario();
		tablaCalendario.setModel(modeloCalendario);
		
		setVisible(true);
	}
	
	/*
	 * Description: Method when the user selects a category of vehicles load the photo of the first
	 * 				vehicle in the category's list
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: List<Vehiculo> lista
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	private void cargaPrimerVehiculo(List<Vehiculo> lista) {
		try {
			lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass()
					.getResource(lista.get(0).getFoto())).getImage()));
			textFieldModelo.setText(lista.get(0).getModelo());
		}catch(NullPointerException e) {
			muestraDialogoCategoriaVacía();
			comboBoxSeleccion.setSelectedIndex(0);
			cargaPrimerVehiculo(listaClasicos);
		}
	}
	
	/*
	 * Description: Method that shows the previous vehicle in the list of vehicles
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: List<Vehiculo> lista, int indice
	 * Return Value: int
	 * Date: 12/02/2022
	 */
	private int muestraVehiculoAnterior(List<Vehiculo> lista, int indice) {
		if (indice == 0) {
			indice = lista.size() - 1;
			try {
				lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass()
						.getResource(lista.get(indice).getFoto()))
						.getImage().getScaledInstance(320, 180, Image.SCALE_SMOOTH)));
			}catch(NullPointerException e) {
				muestraDialogoErrorImagen(lista.get(indice).getModelo());
				estableceImagenNoDisponible();
			}
			textFieldModelo.setText(lista.get(indice).getModelo());
		} else {
			indice = indice - 1;
			try {
				lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass()
						.getResource(lista.get(indice).getFoto()))
						.getImage().getScaledInstance(320, 180, Image.SCALE_SMOOTH)));
			}catch(NullPointerException e) {
				muestraDialogoErrorImagen(lista.get(indice).getModelo());
				estableceImagenNoDisponible();
			}
			textFieldModelo.setText(lista.get(indice).getModelo());
		}
		return indice;
	}

	/*
	 * Description: Method that shows the next vehicle in the list of vehicles
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: List<Vehiculo> lista, int indice
	 * Return Value: int
	 * Date: 12/02/2022
	 */
	private int muestraVehiculoSiguiente(List<Vehiculo> lista, int indice) {
		if (indice == lista.size() - 1) {
			indice = 0;
			try {
				lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass()
						.getResource(lista.get(indice).getFoto()))
						.getImage().getScaledInstance(320, 180, Image.SCALE_SMOOTH)));
			}catch(NullPointerException e) {
				muestraDialogoErrorImagen(lista.get(indice).getModelo());
				estableceImagenNoDisponible();
			}
			textFieldModelo.setText(lista.get(indice).getModelo());
		} else {
			indice = indice + 1;
			try {
				lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass()
						.getResource(lista.get(indice).getFoto()))
						.getImage().getScaledInstance(320, 180, Image.SCALE_SMOOTH)));
			}catch(NullPointerException e) {
				muestraDialogoErrorImagen(lista.get(indice).getModelo());
				estableceImagenNoDisponible();
			}
			textFieldModelo.setText(lista.get(indice).getModelo());
		}
		return indice;
	}
	
	/*
	 * Description: Method that shows a default image for not found photos of vehicles
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	private void estableceImagenNoDisponible() {
		lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass()
				.getResource("\\fotos\\imagenNoDisponible.jpg"))
				.getImage().getScaledInstance(320, 180, Image.SCALE_SMOOTH)));
	}

	/*
	 * Description: Method that shows message to confirm or cancel to log out
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: int
	 * Date: 12/02/2022
	 */
	private int dialogoConfirmaCerrarSesion() {
		int seleccion = JOptionPane.showOptionDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión"
													,0, 3, null, new Object[] {"SI", "NO"}, null);
		return seleccion;
	}
	
	/*
	 * Description: Method that shows message to inform there isn't this kind of vehicle
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: void
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	private void muestraDialogoCategoriaVacía() {
		JOptionPane.showMessageDialog(null, "Disculpe, por el momento no contamos"
										+ " con modelos de esa categoría");
	}
	
	/*
	 * Description: Method that shows message to inform the vehicle's photo was not found 
	 * Author: Mejía Velázquez José Rodrigo
	 * Parameters: String modelo
	 * Return Value: void
	 * Date: 12/02/2022
	 */
	private void muestraDialogoErrorImagen(String modelo) {
		JOptionPane.showMessageDialog(null, "La imagen del vehiculo " + modelo 
										+ " tuvo problemas al cargarse");
	}
}
