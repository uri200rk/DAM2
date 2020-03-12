package Vistes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;

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
		txtUser.setBounds(119, 194, 209, 35);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblGymrk = new JLabel("GYM-RK");
		lblGymrk.setHorizontalAlignment(SwingConstants.CENTER);
		lblGymrk.setFont(new Font("Symbola", Font.BOLD, 61));
		lblGymrk.setBounds(59, 35, 269, 53);
		contentPane.add(lblGymrk);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(136, 378, 114, 25);
		contentPane.add(btnLogin);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Symbola", Font.BOLD, 20));
		lblLogin.setBounds(145, 134, 63, 35);
		contentPane.add(lblLogin);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Symbola", Font.BOLD, 15));
		lblUser.setBounds(41, 200, 43, 25);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Symbola", Font.BOLD, 15));
		lblPassword.setBounds(41, 271, 63, 25);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 265, 209, 35);
		contentPane.add(passwordField);
	}
}
