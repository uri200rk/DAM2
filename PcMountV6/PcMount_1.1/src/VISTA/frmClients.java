package VISTA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.CellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CLASSES.Client;
import DADES.SQLClients;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.desktop.SystemSleepEvent;

public class frmClients extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	//objetos

	SQLClients conector = new SQLClients();
	
	//variables

	String cif, nom, cognom, adreça, tlf, cp, nBancari;

	char opcion;

	// butoms
	
	JButton btnEdit;
	JButton btnDelete;
	JButton btnSave;
	JButton btnNew;

	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			frmClients dialog = new frmClients();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.baseDatosTabla();
			dialog.setVisible(true);
			dialog.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.3
	 */
	public frmClients() {

		setBounds(100, 100, 998, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// DefaultTableModel model = new DefaultTableModel();

		JLabel lblErer = new JLabel("CIF");

		txtField = new JTextField();
		txtField.setText(cif);
		txtField.setColumns(10);

		JLabel lblNom = new JLabel("NOM");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblCognom = new JLabel("COGNOM");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblAdrea = new JLabel("ADREÇA");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel lblCp = new JLabel("CP");

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JLabel lblTlf = new JLabel("TLF");

		JLabel lblNbancari = new JLabel("N.BANCARI");

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);

	

		// ocultar botones

		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(30)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblErer).addGap(33)
										.addComponent(txtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(56).addComponent(lblNom).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(65).addComponent(lblCognom))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblCp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addGap(56)
										.addComponent(lblTlf, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addGap(65).addComponent(lblNbancari)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
										.addComponent(lblAdrea).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addGap(25))))
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE).addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel
						.createSequentialGroup().addGap(
								21)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblErer)
								.addComponent(txtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNom)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCognom)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdrea).addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTlf)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNbancari)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCp))
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)));

		table = new JTable();
		table.setUpdateSelectionOnSort(false);
		table.setBackground(SystemColor.text);
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);

		{

			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			// *********************************************************************************************
			// **************************************BUTOMS*************************************************
			// *********************************************************************************************

			// ------------------------------------------ACTION BOTON DELETE--------------------------------------------------------------------------------

			btnDelete = new JButton("DELETE");
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnNew.setEnabled(true);

					try {
						int dialogButton = 0;
						int opcionConfirmacion = JOptionPane.showConfirmDialog(null, "Deseas eliminarlo?", "Warning", dialogButton);

						if (opcionConfirmacion == JOptionPane.YES_OPTION) {
							conector.deleteClients(new Client(cif));
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					refresh();
					baseDatosTabla();
				}
			});
			btnDelete.setActionCommand("OK");

			// -----------------------------------------------ACTION BOTON NEW--------------------------------------------------------------------------

			btnNew = new JButton("NEW");
			btnNew.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
					opcion = 'n';
					
					btnDelete.setEnabled(false);
					btnEdit.setEnabled(false);
					
					txtField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");

					txtField.setEnabled(true);

					textField_1.setEnabled(true);
					textField_2.setEnabled(true);
					textField_3.setEnabled(true);
					textField_4.setEnabled(true);
					textField_5.setEnabled(true);
					textField_6.setEnabled(true);
					txtField.requestFocus();

				}
			});
			btnNew.setActionCommand("OK");

			// ----------------------------------------------------------ACTION EDIT-----------------------------------------------------------------------------------------------------------

			btnEdit = new JButton("EDIT");
			btnEdit.setEnabled(false);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					opcion = 'e';
					btnNew.setEnabled(true);

					try {

						txtField.setEnabled(false);

						textField_1.setEnabled(true);
						textField_2.setEnabled(true);
						textField_3.setEnabled(true);
						textField_4.setEnabled(true);
						textField_5.setEnabled(true);
						textField_6.setEnabled(true);

					} catch (Exception e) {
						System.out.println("Marca primer un registre");
					}

				}
			});

			btnEdit.setActionCommand("OK");

			btnSave = new JButton("SAVE");
			btnSave.addActionListener(new ActionListener() {

				// -----------------------------------------------------ACTION BOTON SAVE----------------------------------------------------------------------

				public void actionPerformed(ActionEvent arg0) {

					try {
						cif = txtField.getText().toString();
						nom = textField_1.getText().toString();
						cognom = textField_2.getText().toString();
						adreça = textField_3.getText().toString();
						cp = textField_4.getText().toString();
						tlf = textField_5.getText().toString();
						nBancari = textField_6.getText().toString();

						if (txtField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "introdueix com a minim el camp cif");
						} else {
							if (opcion == 'n') {
								System.out.println("entro--------------------------------------------------");
								System.out.println(cif + nom + cognom + adreça + cp + tlf + nBancari);
								conector.insertaClients(new Client(cif, nom, cognom, adreça, cp, tlf, nBancari));
							} else if (opcion == 'e') {
								conector.updateClients(new Client(cif, nom, cognom, adreça, cp, tlf, nBancari));
							}

							refresh();

						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					btnNew.setEnabled(true);
					baseDatosTabla();

				}

			});

			btnSave.setActionCommand("OK");
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addContainerGap()
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addContainerGap()));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(5)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE).addComponent(btnSave)
									.addComponent(btnEdit).addComponent(btnNew).addComponent(btnDelete))));
			buttonPane.setLayout(gl_buttonPane);

		}

	}

	// ***********************************************************************************************************
	// *********************************************METODES*******************************************************
	// ***********************************************************************************************************

	public void refresh() {

		txtField.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		textField_3.setEnabled(false);
		textField_4.setEnabled(false);
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);

		txtField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");

		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);

	}

	public void baseDatosTabla() {
		// DATA BASE

		SQLClients datos = new SQLClients();
		datos.conectar();

		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("CIF");
		model.addColumn("NOM");
		model.addColumn("COGNOM");
		model.addColumn("ADREÇA");
		model.addColumn("CODIPOSTAL");
		model.addColumn("TLF");
		model.addColumn("NBANCARI");

		table.setModel(model);
		model.setRowCount(0);

		try {
			for (Client client : datos.consultaClients("Clients")) {

				model.addRow(new Object[] { client.getCif(), client.getNom(), client.getCognom(), client.getAdreça(),
						client.getCodiPostal(), client.getTlf(), client.getnBancari() });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.out.println("Click!");
				if (e.getClickCount() == 1) {

					final JTable jtable = (JTable) e.getSource();
					final int row = jtable.getSelectedRow();

					// obtenemos los valores selecionados i los guardamos en la variable
					cif = (String) jtable.getValueAt(row, 0);
					nom = (String) jtable.getValueAt(row, 1);
					cognom = (String) jtable.getValueAt(row, 2);
					adreça = (String) jtable.getValueAt(row, 3);
					cp = (String) jtable.getValueAt(row, 4);
					tlf = (String) jtable.getValueAt(row, 5);
					nBancari = (String) jtable.getValueAt(row, 6);

					// poner valores en recuadros blancos
					txtField.setText(cif);
					textField_1.setText(nom);
					textField_2.setText(cognom);
					textField_3.setText(adreça);
					textField_4.setText(cp);
					textField_5.setText(tlf);
					textField_6.setText(nBancari);
					System.out.println(cif + nom + cognom);

					String cifU = txtField.getText().toString();
					String nomU = textField_1.getText().toString();
					String cognomU = textField_2.getText().toString();
					System.out.println("cif:" + cifU + nomU + cognomU);
					
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
					btnNew.setEnabled(true);

					txtField.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);

				} else {
					System.out.println("Marca primer un registre");
				}
			}
		});
	}

}
