package mx.uami.ingsoft.proyecto.rentaAutos.presentacion.principalCliente;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Cliente;
import mx.uami.ingsoft.proyecto.rentaAutos.negocio.modelo.Vehiculo;

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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Image;

@Slf4j
@SuppressWarnings("serial")
@Component
public class VistaPrincipalCliente extends JFrame{

	private ControlPrincipalCliente control;
	private Cliente cliente;
	private JTextField textFieldBusqueda;
	private JLabel lblCliente;
	private List<Vehiculo> listaPedido;
	private JTable table;
	private JLabel lblFoto;
	private JTextField textField;
	private JButton btnAgregarAPedido;
	private JButton btnEspecificaciones;
	private JButton btnVehiculoPrevio;
	private JButton btnVehiculoSiguiente;
	private JTextField textFieldMes;
	private List<Vehiculo> listaClasicos;
	private List<Vehiculo> listaLujo;
	private List<Vehiculo> listaDeportivos;
	private List<Vehiculo> listaCarga;

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
		lblLogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("\\fotos\\backend.png"))
						.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(10, 10, 120, 100);
		getContentPane().add(lblLogo);
		
		JLabel lblBienvenida = new JLabel("Bienvenido: ");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setBounds(140, 40, 150, 40);
		getContentPane().add(lblBienvenida);
		
		lblCliente = new JLabel();
		lblCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCliente.setBounds(290, 40, 150, 40);
		getContentPane().add(lblCliente);
		
		table = new JTable();
		table.setBounds(10, 175, 126, 150);
		getContentPane().add(table);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(220, 180, 320, 180);
		getContentPane().add(lblFoto);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(220, 155, 320, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAgregarAPedido = new JButton("Agregar a pedido");
		btnAgregarAPedido.setBounds(240, 360, 140, 25);
		getContentPane().add(btnAgregarAPedido);
		
		btnEspecificaciones = new JButton("Especificaciones");
		btnEspecificaciones.setBounds(380, 360, 140, 25);
		getContentPane().add(btnEspecificaciones);
		
		btnVehiculoPrevio = new JButton("<");
		btnVehiculoPrevio.setBounds(190, 360, 50, 25);
		getContentPane().add(btnVehiculoPrevio);
		
		btnVehiculoSiguiente = new JButton(">");
		btnVehiculoSiguiente.setBounds(520, 360, 50, 25);
		getContentPane().add(btnVehiculoSiguiente);
		
		textFieldMes = new JTextField();
		textFieldMes.setEditable(false);
		textFieldMes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMes.setBounds(10, 150, 126, 25);
		getContentPane().add(textFieldMes);
		textFieldMes.setColumns(10);
		
		JComboBox<String> comboBoxSeleccion = new JComboBox<String>();
		comboBoxSeleccion.setModel(new DefaultComboBoxModel<String>(new String[] {"Clásicos", "Lujo", "Deportivos", "Carga"}));
		comboBoxSeleccion.setBounds(350, 130, 140, 25);
		getContentPane().add(comboBoxSeleccion);
		
		JLabel lblCategorias = new JLabel("Categorías");
		lblCategorias.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategorias.setBounds(270, 130, 80, 25);
		getContentPane().add(lblCategorias);
	}
	
	public void muestra(ControlPrincipalCliente controlPrincipalCliente, Cliente cliente, List<Vehiculo> listaClasicos, List<Vehiculo> listaLujo, List<Vehiculo> listaDeportivos, List<Vehiculo> listaCarga) {
		this.control = controlPrincipalCliente;
		this.cliente = cliente;
		this.listaClasicos = listaClasicos;
		this.listaLujo = listaLujo;
		this.listaDeportivos = listaDeportivos;
		this.listaCarga = listaCarga;
		
		lblCliente.setText(cliente.getNombreUsuario());
		textFieldMes.setText(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase());
		
		log.info("En vista");
		log.info("tamaño lista: " + listaClasicos.size());
		log.info(listaClasicos.get(0).getFoto());
		
		lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(listaClasicos.get(0).getFoto())).getImage()));
		
		setVisible(true);
	}

	public void muestraDialogoListaVacía() {
		JOptionPane.showMessageDialog(null, "La lista está vacía");
		
	}
}
