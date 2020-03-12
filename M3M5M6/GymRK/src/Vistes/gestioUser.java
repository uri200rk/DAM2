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
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Image;
import javax.swing.ImageIcon;

public class gestioUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBackground(Color.DARK_GRAY);
		btnPagar.setBounds(0, 510, 257, 79);
		panel_1.add(btnPagar);
		btnPagar.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/imagenes/logoGym.png")).getImage();
		logo.setBounds(86, 54, 95, 60);
		logo.setIcon(new ImageIcon(img));

		panel_1.add(logo);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(253, 244, 735, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHistorial = new JLabel("HISTORIAL");
		lblHistorial.setForeground(new Color(105, 105, 105));
		lblHistorial.setBounds(35, 12, 231, 42);
		lblHistorial.setFont(new Font("Dialog", Font.BOLD, 35));
		panel.add(lblHistorial);
		
		table = new JTable();
		table.setBounds(35, 68, 669, 298);
		panel.add(table);
		
		textField = new JTextField();
		textField.setBounds(451, 85, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(451, 136, 124, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(451, 188, 124, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(754, 85, 124, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(754, 136, 124, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(754, 188, 124, 19);
		contentPane.add(textField_5);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(352, 87, 66, 15);
		contentPane.add(lblDni);
		
		JLabel lblNom = new JLabel("NOM\n");
		lblNom.setBounds(352, 138, 66, 15);
		contentPane.add(lblNom);
		
		JLabel lblCognom = new JLabel("COGNOM\n");
		lblCognom.setBounds(352, 190, 66, 15);
		contentPane.add(lblCognom);
		
		JLabel lblMail = new JLabel("MAIL\n");
		lblMail.setBounds(670, 87, 66, 15);
		contentPane.add(lblMail);
		
		JLabel lblIban = new JLabel("IBAN");
		lblIban.setBounds(670, 138, 66, 15);
		contentPane.add(lblIban);
		
		JLabel lblTlf = new JLabel("TLF");
		lblTlf.setBounds(670, 190, 66, 15);
		contentPane.add(lblTlf);
		
		JLabel lblDadesPersonals = new JLabel("DADES PERSONALS\n");
		lblDadesPersonals.setForeground(new Color(105, 105, 105));
		lblDadesPersonals.setFont(new Font("Dialog", Font.BOLD, 35));
		lblDadesPersonals.setBounds(277, 12, 401, 42);
		contentPane.add(lblDadesPersonals);
	}
}
