package Vistes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class gestioAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestioAdmin frame = new gestioAdmin();
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
		
		JButton btnEditarClient = new JButton("EDITAR CLIENT");
		btnEditarClient.setForeground(Color.WHITE);
		btnEditarClient.setBackground(Color.DARK_GRAY);
		btnEditarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditarClient.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnEditarClient.setBounds(0, 83, 257, 79);
		panel_1.add(btnEditarClient);
		
		JButton btnEliminarClient = new JButton("ELIMINAR CLIENT\n");
		btnEliminarClient.setForeground(Color.WHITE);
		btnEliminarClient.setBackground(Color.DARK_GRAY);
		btnEliminarClient.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnEliminarClient.setBounds(0, 165, 257, 79);
		panel_1.add(btnEliminarClient);
		
		JButton btnInsertarClient = new JButton("INSERTAR CLIENT");
		btnInsertarClient.setForeground(Color.WHITE);
		btnInsertarClient.setBackground(Color.DARK_GRAY);
		btnInsertarClient.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnInsertarClient.setBounds(0, 0, 257, 79);
		panel_1.add(btnInsertarClient);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(153, 204, 204));
		panel_2.setBounds(0, 244, 1006, 400);
		panel.add(panel_2);
		
		JLabel lblUsuaris = new JLabel("CLIENTS");
		lblUsuaris.setForeground(new Color(105, 105, 105));
		lblUsuaris.setFont(new Font("Dialog", Font.BOLD, 35));
		lblUsuaris.setBounds(35, 12, 231, 42);
		panel_2.add(lblUsuaris);
		
		table = new JTable();
		table.setBounds(35, 68, 928, 298);
		panel_2.add(table);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(851, 21, 114, 25);
		panel_2.add(btnBuscar);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(317, 21, 646, 25);
		panel_2.add(textField_6);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(451, 85, 124, 19);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(451, 136, 124, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(451, 188, 124, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(754, 85, 124, 19);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(754, 136, 124, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(754, 188, 124, 19);
		panel.add(textField_5);
		
		JLabel label_1 = new JLabel("DNI");
		label_1.setBounds(352, 87, 66, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("NOM\n");
		label_2.setBounds(352, 138, 66, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("COGNOM\n");
		label_3.setBounds(352, 190, 66, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("MAIL\n");
		label_4.setBounds(670, 87, 66, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("IBAN");
		label_5.setBounds(670, 138, 66, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("TLF");
		label_6.setBounds(670, 190, 66, 15);
		panel.add(label_6);
		
		JLabel lblDadesUsuari = new JLabel("DADES CLIENT\n");
		lblDadesUsuari.setForeground(new Color(105, 105, 105));
		lblDadesUsuari.setFont(new Font("Dialog", Font.BOLD, 35));
		lblDadesUsuari.setBounds(277, 12, 401, 42);
		panel.add(lblDadesUsuari);
	}
}
