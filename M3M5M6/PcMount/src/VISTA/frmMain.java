package VISTA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 757, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMen = new JMenu("Menú");
		menuBar.add(mnMen);
		
		JMenuItem mntmGestiClients = new JMenuItem("Gestió Clients");
		mntmGestiClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmClients frame = new frmClients();
		        frame.setVisible(true);
			}
			
		});
		mnMen.add(mntmGestiClients);
		
		JMenuItem mntmGestiComandes = new JMenuItem("Gestió Comandes");
		mntmGestiComandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmComandes frame = new frmComandes();
		        frame.setVisible(true);
			}
		});
		mnMen.add(mntmGestiComandes);
	}

}
