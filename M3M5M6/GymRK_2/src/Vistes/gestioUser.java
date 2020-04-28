package Vistes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Acces;
import Clases.Client;
import Dades.SQLClients;
import Dades.SQLFitxades;

import javax.swing.JTable;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Vistes.Login;
import javax.swing.JScrollPane;

public class gestioUser extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;

	// objetos

	static Login login = new Login();
	SQLFitxades fitxada = new SQLFitxades();


	// variables
	static String dni;
	
	// declaracion de objeto cliente
	 static Client registro;
	 private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestioUser frame = new gestioUser();
					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public gestioUser() {
		

		// ELEMENTOS VENTANA

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 669);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBounds(0, 0, 259, 644);
		contentPane.add(panel_1);

		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(Color.DARK_GRAY);
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEntrar.setBounds(0, 38, 257, 79);
		panel_1.add(btnEntrar);
		
		JButton btnSortir = new JButton("SORTIR");
		btnSortir.setForeground(Color.WHITE);
		btnSortir.setBackground(Color.DARK_GRAY);
		btnSortir.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSortir.setBounds(0, 129, 257, 79);
		panel_1.add(btnSortir);
		
		//----------------------------------------------------BOTON ENTRAR------------------------------------------------------

		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				//Obtencion fecha y hora actual
				
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				System.out.println("Hora y fecha: "+hourdateFormat.format(date));
				
				
				fitxada.insertaFitxada(new Acces(hourdateFormat.format(date),"e", registro.getDni(),registro.getCifGym()));
				
				//refrescar tabla
				registrosFixadas();
				
				//control de acceso a botones
				btnEntrar.setEnabled(false);
				btnSortir.setEnabled(true);


			}
		});

		
		//-----------------------------------------------------BOTON SALIR-------------------------------------------------------
		
		btnSortir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				//Obtencion fecha y hora actual
				
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				System.out.println("Hora y fecha: "+hourdateFormat.format(date));
				
				
				fitxada.insertaFitxada(new Acces(hourdateFormat.format(date),"s", registro.getDni(), registro .getCifGym()));
				
				//refrescar tabla
				registrosFixadas();

				//control de acceso a botones
				btnSortir.setEnabled(false);
				btnEntrar.setEnabled(true);


			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(253, 244, 735, 400);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblHistorial = new JLabel("HISTORIAL DE FITXADES");
		lblHistorial.setForeground(new Color(105, 105, 105));
		lblHistorial.setBounds(35, 12, 418, 42);
		lblHistorial.setFont(new Font("Dialog", Font.BOLD, 35));
		panel.add(lblHistorial);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 67, 664, 297);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setViewportView(table);


		textField = new JTextField();
		textField.setBounds(344, 87, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(344, 138, 124, 19);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(344, 190, 124, 19);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(578, 87, 124, 19);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(578, 138, 124, 19);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(578, 190, 124, 19);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setColumns(10);
		textField_6.setBounds(834, 190, 124, 19);
		contentPane.add(textField_6);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(277, 89, 66, 15);
		contentPane.add(lblDni);

		JLabel lblNom = new JLabel("NOM\n");
		lblNom.setBounds(277, 140, 66, 15);
		contentPane.add(lblNom);

		JLabel lblCognom = new JLabel("COGNOM\n");
		lblCognom.setBounds(277, 192, 66, 15);
		contentPane.add(lblCognom);

		JLabel lblMail = new JLabel("MAIL\n");
		lblMail.setBounds(514, 89, 66, 15);
		contentPane.add(lblMail);

		JLabel lblIban = new JLabel("IBAN");
		lblIban.setBounds(514, 140, 66, 15);
		contentPane.add(lblIban);

		JLabel lblTlf = new JLabel("TLF");
		lblTlf.setBounds(514, 192, 66, 15);
		contentPane.add(lblTlf);

		JLabel lblDadesPersonals = new JLabel("DADES PERSONALS\n");
		lblDadesPersonals.setForeground(new Color(105, 105, 105));
		lblDadesPersonals.setFont(new Font("Dialog", Font.BOLD, 35));
		lblDadesPersonals.setBounds(277, 12, 401, 42);
		contentPane.add(lblDadesPersonals);

		JLabel lblSpagament = new JLabel("S.PAGAMENT");
		lblSpagament.setBounds(746, 193, 76, 15);
		contentPane.add(lblSpagament);

		// ----------------------------------------------------------------

		// bloquear escriptura en campos cliente

		textField.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		textField_3.setEnabled(false);
		textField_4.setEnabled(false);
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);

		// obtencion dni cliente
		dni = login.getDNI();
		System.out.println(dni);
		registroCliente();
		registrosFixadas();

	}
	

	// METODOS


	// metodo para rellenar los campos
	public static void registroCliente() {



		// conexion base de datos
		SQLClients datos = new SQLClients();
		datos.conectar();

		// consultar cliente
		registro = datos.consultaClientDNI("Client", dni);

		System.out.println(registro.getNom());

		textField.setText(registro.getDni());
		textField_1.setText(registro.getNom());
		textField_2.setText(registro.getCognom());
		textField_3.setText(registro.getMail());
		textField_4.setText(registro.getIban());
		textField_5.setText(Integer.toString(registro.getTlf()));
		textField_6.setText(registro.getStatPagament());

	}

	// metodo para mostrar registros de fixadas
	public static void registrosFixadas() {

		// DATA BASE

		SQLFitxades datos = new SQLFitxades();
		datos.conectar();

		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("ID");
		model.addColumn("DATA_FITXADA");
		model.addColumn("TIPUS");
		model.addColumn("DNI");
		model.addColumn("CIF");
		model.setRowCount(0);
		
		table.setModel(model);
		model.setRowCount(0);

		for (Acces fitxada : datos.consultaFitxades("Fitxades", registro.getDni())) {

			model.addRow(new Object[] { fitxada.getCheckId(), fitxada.getDataHoraFitxada(), fitxada.getTipus(),
					fitxada.getDni(), fitxada.getCif() });

		}
		


		// click registro

		/*
		 * table.addMouseListener(new MouseAdapter() {
		 * 
		 * public void mouseClicked(MouseEvent e) { System.out.println("Click!"); if
		 * (e.getClickCount() == 1) {
		 * 
		 * final JTable jtable = (JTable) e.getSource(); final int row =
		 * jtable.getSelectedRow();
		 * 
		 * // obtenemos los valores selecionados i los guardamos en la variable dni =
		 * (String) jtable.getValueAt(row, 0); nom = (String) jtable.getValueAt(row, 1);
		 * cognom = (String) jtable.getValueAt(row, 2); mail = (String)
		 * jtable.getValueAt(row, 3); iban = (String) jtable.getValueAt(row, 4); tlf =
		 * (int) jtable.getValueAt(row, 5); statPagament = (Boolean)
		 * jtable.getValueAt(row, 6); admin = (Boolean) jtable.getValueAt(row, 7);
		 * 
		 * 
		 * // poner valores en recuadros blancos textField.setText(dni);
		 * textField_1.setText(nom); textField_2.setText(cognom);
		 * textField_3.setText(mail); textField_4.setText(iban);
		 * textField_5.setText(Integer.toString(tlf));
		 * textField_6.setText(Boolean.toString(statPagament));
		 * 
		 * 
		 * 
		 * textField.setEnabled(false); textField_1.setEnabled(false);
		 * textField_2.setEnabled(false); textField_3.setEnabled(false);
		 * textField_4.setEnabled(false); textField_5.setEnabled(false);
		 * textField_6.setEnabled(false);
		 * 
		 * } else { System.out.println("Marca primer un registre"); } } });
		 */

	}

}
