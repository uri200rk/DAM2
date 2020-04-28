package Vistes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JFrame frame;

	
	//variables
	static String dni;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(new Color(119, 136, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("");
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setBounds(141, 194, 187, 35);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblGymrk = new JLabel("GYM-RK");
		lblGymrk.setHorizontalAlignment(SwingConstants.CENTER);
		lblGymrk.setFont(new Font("Symbola", Font.BOLD, 61));
		lblGymrk.setBounds(49, 13, 269, 53);
		contentPane.add(lblGymrk);
		
		
			

		
		
		//-----------------------------------------------------------BOTON LOGIN-------------------------------------------------------------
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(136, 378, 114, 25);
		contentPane.add(btnLogin);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Symbola", Font.BOLD, 20));
		lblLogin.setBounds(152, 89, 63, 35);
		contentPane.add(lblLogin);
		
		
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
					dni = txtUser.getText().toString(); //cojer valor texto dni
					getDNI();	//Guardar dni
					
			       	gestioUser frame = new gestioUser();
			       	frame.show();	//visualització nova finestra 	finestra
			       	dispose();		//tancament finestra login
			       
				
			}
					
			
			
		});
		
		
		
		
		
		//--------------------------------------------------------------------------------------------------------------------------------------
		
		JLabel lblUser = new JLabel("DNI");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Symbola", Font.BOLD, 15));
		lblUser.setBounds(41, 200, 43, 25);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Symbola", Font.BOLD, 15));
		lblPassword.setBounds(41, 271, 88, 25);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 265, 187, 35);
		contentPane.add(passwordField);
		
	}
	
	
	
	//METODOS
	
	
	//metode per retornar dni a finestra gestor usuari

	public String getDNI() {
		
		return dni;
		
	}
	
	
	
	
	
	
	
	
	
}
