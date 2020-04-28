package Vistes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Client;
import Dades.SQLClients;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class gestioAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField_8;
	private static JTextField textField_9;

	
	//conexion
	
	static SQLClients c = new SQLClients();

	
	//variables
	
	static String dni;
	static String nom;
	static String cognom;
	static String mail;
	static String iban;
	static String cifGym;
	static String sPagament;
	static int tlf;
	static String tUsuari;
	char opcion;
	
	
	// butoms
	
	static JButton btnEditarClient;
	static JButton btnEliminarClient;
	static JButton btnInsertarClient;
	static JButton btnGuardar;
	private static JTable table;


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestioAdmin frame = new gestioAdmin();
					frame.setVisible(true);
					baseDatosTabla();
					refresh();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gestioAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 204, 153));
		panel.setBounds(0, 0, 994, 644);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(0, 0, 259, 246);
		panel.add(panel_1);
		
		
		
		//---------------------------------------------BOTON EDITAR CLIENTE------------------------------------------------------
		
		btnEditarClient = new JButton("EDITAR CLIENT");
		btnEditarClient.setForeground(Color.WHITE);
		btnEditarClient.setBackground(Color.DARK_GRAY);
		btnEditarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditarClient.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnEditarClient.setBounds(0, 83, 257, 79);
		panel_1.add(btnEditarClient);
		
		
		btnEditarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcion = 'e';
				btnInsertarClient.setEnabled(false);
				btnEliminarClient.setEnabled(false);


				try {

					textField.setEnabled(false);
					textField_1.setEnabled(true);
					textField_2.setEnabled(true);
					textField_3.setEnabled(true);
					textField_4.setEnabled(true);
					textField_5.setEnabled(true);
					textField_6.setEnabled(false);
					textField_8.setEnabled(true);

				} catch (Exception e) {
					System.out.println("Marca primer un registre");
				}

			}
		});
		
		
	
		//--------------------------------------------BOTON ELIMINAR CLIENTE------------------------------------------------------
		
		btnEliminarClient = new JButton("ELIMINAR CLIENT\n");
		btnEliminarClient.setForeground(Color.WHITE);
		btnEliminarClient.setBackground(Color.DARK_GRAY);
		btnEliminarClient.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnEliminarClient.setBounds(0, 165, 257, 79);
		panel_1.add(btnEliminarClient);
		
		btnEliminarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnInsertarClient.setEnabled(false);
				btnEditarClient.setEnabled(false);



				try {
					int dialogButton = 0;
					int opcionConfirmacion = JOptionPane.showConfirmDialog(null, "Deseas eliminarlo?", "Warning", dialogButton);

					if (opcionConfirmacion == JOptionPane.YES_OPTION) {
						System.out.println("dni-------------------"+dni);
						c.deleteClients(new Client(dni));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				refresh();
				baseDatosTabla();
			}
		});
	
	
		
		//-----------------------------------------------------BOTON INSERTAR CLIENTE-------------------------------------------------
		
		
		btnInsertarClient = new JButton("INSERTAR CLIENT");
		btnInsertarClient.setForeground(Color.WHITE);
		btnInsertarClient.setBackground(Color.DARK_GRAY);
		btnInsertarClient.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnInsertarClient.setBounds(0, 0, 257, 79);
		panel_1.add(btnInsertarClient);
		
		
		btnInsertarClient.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				opcion = 'n';
				
				btnEliminarClient.setEnabled(false);
				btnEditarClient.setEnabled(false);
			
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_8.setText("");
				textField_9.setText("");

				textField.setEnabled(true);
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);
				textField_8.setEnabled(true);
				textField_9.setEnabled(true);

				
				textField.requestFocus();

			}
		});
		
		
		
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(153, 204, 204));
		panel_2.setBounds(0, 244, 1006, 400);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		JLabel lblUsuaris = new JLabel("CLIENTS");
		lblUsuaris.setBounds(12, 12, 231, 42);
		lblUsuaris.setForeground(new Color(105, 105, 105));
		lblUsuaris.setFont(new Font("Dialog", Font.BOLD, 35));
		panel_2.add(lblUsuaris);

		
		

		//------------------------------------------
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(826, 21, 114, 25);
		panel_2.add(btnBuscar);
		
		textField_7 = new JTextField();
		textField_7.setBounds(317, 21, 510, 25);
		textField_7.setColumns(10);
		panel_2.add(textField_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(12, 67, 952, 296);
		panel_2.add(scrollPane);
		scrollPane.getViewport().setBackground(Color.WHITE);

		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		//---------------------------------------------------------BOTON BUSCAR---------------------------------------------------
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		

		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(342, 87, 124, 19);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(342, 138, 124, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 190, 124, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(569, 87, 124, 19);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(569, 138, 124, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(569, 190, 124, 19);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(833, 140, 124, 19);
		panel.add(textField_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(833, 87, 124, 19);
		panel.add(textField_8);
		
		JLabel label_1 = new JLabel("DNI");
		label_1.setBounds(277, 89, 66, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("NOM\n");
		label_2.setBounds(277, 140, 66, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("COGNOM\n");
		label_3.setBounds(277, 192, 66, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("MAIL\n");
		label_4.setBounds(509, 89, 66, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("IBAN");
		label_5.setBounds(509, 140, 66, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("TLF");
		label_6.setBounds(509, 192, 66, 15);
		panel.add(label_6);
		
		JLabel label_4_1 = new JLabel("S.PAGAMENT");
		label_4_1.setBounds(730, 141, 77, 15);
		panel.add(label_4_1);
		
		JLabel label_4_2 = new JLabel("CIF_GYM\n");
		label_4_2.setBounds(730, 90, 66, 15);
		panel.add(label_4_2);
		
		JLabel lblDadesUsuari = new JLabel("DADES CLIENT\n");
		lblDadesUsuari.setForeground(new Color(105, 105, 105));
		lblDadesUsuari.setFont(new Font("Dialog", Font.BOLD, 35));
		lblDadesUsuari.setBounds(277, 12, 401, 42);
		panel.add(lblDadesUsuari);
		
		
		
		
		
		
		//------------------------------------------------------BOTON SAVE-----------------------------------------------------
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(829, 12, 114, 25);

		panel.add(btnGuardar);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
	
				try {
					dni = textField.getText().toString();
					nom = textField_1.getText().toString();
					cognom = textField_2.getText().toString();
					mail = textField_3.getText().toString();
					iban = textField_4.getText().toString();
					tlf = Integer.parseInt(textField_5.getText().toString());
					cifGym = textField_8.getText().toString();
					sPagament = textField_6.getText().toString();
					tUsuari = textField_9.getText().toString();
					System.out.println(cifGym);
	
					
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "introdueix com a minim el camp cif");
					} else {
						if (opcion == 'n') {

							c.insertaClients(new Client(dni, nom, cognom, mail, iban, tlf, sPagament, tUsuari, cifGym));
							
						} else if (opcion == 'e') {
							c.updateClients(new Client(dni, nom, cognom, mail, iban, tlf, cifGym));
						}
	
						
	
					}
					
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				refresh();
				baseDatosTabla();
	
			}
		
		});
		
		
		//-----------------------------------------------------BOTON CANCELAR--------------------------------------------------
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(704, 12, 114, 25);
		panel.add(btnCancelar);
		
		JLabel label_4_1_1 = new JLabel("T.USUARI");
		label_4_1_1.setBounds(730, 192, 77, 15);
		panel.add(label_4_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(833, 189, 124, 19);
		panel.add(textField_9);

		
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				refresh();
				
			}
					
			
			
		});
		
		
		
		
		
		
		//----------------------------------------------------------------------------------------------------------------------
	}
	
	
	/*
	 * METODOS
	 */
	
	//metode per tornar les preferencies de botons i camps de text com l'inici
	public static void refresh() {

		textField.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		textField_3.setEnabled(false);
		textField_4.setEnabled(false);
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);
		textField_8.setEnabled(false);
		textField_9.setEnabled(false);

		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_8.setText("");
		textField_9.setText("");

		btnEditarClient.setEnabled(true);
		btnEliminarClient.setEnabled(true);
		btnInsertarClient.setEnabled(true);

	}
	
	
	
	
	
	@SuppressWarnings("serial")
	public static void baseDatosTabla() {
		
		// DATA BASE

		SQLClients datos = new SQLClients();
		datos.conectar();

		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("DNI");
		model.addColumn("NOM");
		model.addColumn("COGNOM");
		model.addColumn("MAIL");
		model.addColumn("IBAN");
		model.addColumn("TLF");
		model.addColumn("STAT_PAGAMENT");
		model.addColumn("T.USUARIO");
		model.addColumn("CIF_GYM");

		table.setModel(model);
		model.setRowCount(0);
		
		System.out.println("mostrando clientes cargados......");
		for (Client client : datos.consultaClients("Client")) {

			model.addRow(new Object[] { client.getDni(), client.getNom(), client.getCognom(), client.getMail(),
					client.getIban(), client.getTlf(), client.getStatPagament(), client.getAdmin(), client.getCifGym() });
			System.out.println(client.getStatPagament());
		}
		
		
		// click registro
		
		
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.out.println("Click!");
				if (e.getClickCount() == 1) {

					final JTable jtable = (JTable) e.getSource();
					final int row = jtable.getSelectedRow();

					// obtenemos los valores selecionados i los guardamos en la variable
					dni = (String) jtable.getValueAt(row, 0);
					nom = (String) jtable.getValueAt(row, 1);
					cognom = (String) jtable.getValueAt(row, 2);
					mail = (String) jtable.getValueAt(row, 3);
					iban = (String) jtable.getValueAt(row, 4);
					tlf = (int) jtable.getValueAt(row, 5);
					sPagament = (String) jtable.getValueAt(row, 6);
					tUsuari = (String) jtable.getValueAt(row, 7);
					cifGym = (String) jtable.getValueAt(row, 8);


					// poner valores en recuadros blancos
					textField.setText(dni);
					textField_1.setText(nom);
					textField_2.setText(cognom);
					textField_3.setText(mail);
					textField_4.setText(iban);
					textField_5.setText(Integer.toString(tlf));
					textField_6.setText(sPagament);
					textField_8.setText(cifGym);
					textField_9.setText(tUsuari);

					

					textField.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);
					textField_8.setEnabled(false);
					textField_9.setEnabled(false);

				} else {
					System.out.println("Marca primer un registre");
				}
			}
		});
			
	}
}
