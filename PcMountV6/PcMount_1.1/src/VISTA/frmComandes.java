package VISTA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import CLASSES.Comanda;
import CLASSES.LiniaComanda;
import DADES.SQLLiniesComanda;
import DADES.SQLComandes;
import DADES.lectorXml;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSpinner;



public class frmComandes extends JDialog {
	
	//variables
	

	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	//objetos
	
	lectorXml lectorXml = new lectorXml();
	SQLComandes SQLComandes = new SQLComandes();
	SQLLiniesComanda SQLLiniesComanda = new SQLLiniesComanda();
	private JTable table;
	private JTable table_1;
	int casoBoton;
	JSpinner spinner;
	
	
	
	public static void main(String[] args) {
		try {
			frmComandes dialog = new frmComandes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.baseDatosTablaComandas();
			dialog.baseDatosTablaComandasLinia();
			String valorSpinner = "0";
			dialog.actualizarUnidades();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmComandes() {
		
		//llamada a metodos iniciales
		
		
		
		
		setBounds(100, 100, 1033, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 844, 178);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		{
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(12, 214, 844, 169);
			contentPanel.add(scrollPane_1);
			{
				table_1 = new JTable();
				scrollPane_1.setViewportView(table_1);
			}
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(868, 12, 153, 371);
		contentPanel.add(scrollPane_1);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.focus"));
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);
		
		
		
		//----------------BUTTON TOTES------------------------------
		JButton btnTotes = new JButton("TOTES");
		btnTotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				casoBoton = 0;
				idComandaIndex = "";
				baseDatosTablaComandas();
				baseDatosTablaComandasLinia();
				
		
			}
		});
		btnTotes.setBounds(12, 133, 126, 25);
		panel.add(btnTotes);
		
		
		
		
		//-------------------------BUTTON OBERTES-----------------------------------
		
		
		JButton btnObertes = new JButton("OBERTES");
		btnObertes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				casoBoton = 1;
				baseDatosTablaComandas();
					
			}
		});
		btnObertes.setBounds(12, 96, 126, 25);
		panel.add(btnObertes);
		
		
		
		//-------------------------BUTTON TANCADES---------------------------------------
		JButton btnTancades = new JButton("TANCADES");
		btnTancades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				casoBoton = 2;
				
				baseDatosTablaComandas();
				
				
			}
		});
		btnTancades.setBounds(12, 59, 126, 25);
		panel.add(btnTancades);
		
		//-------------------------SPINNER----------------------------------------------------
		spinner = new JSpinner();
		spinner.setBounds(12, 242, 126, 30);
		panel.add(spinner);
		
		
		//--------------------------BUTTON ACTUALIZAR------------------------------------------------
		JButton btnNewButton = new JButton("Actualitzar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarUnidades();
				LiniaComanda liniaComanda = new LiniaComanda( idLinia, idComanda);
				
				liniaComanda.setUnitatsServides((int)spinner.getValue());
				try {
					
					if ((int)spinner.getValue() <= unitatsDemanades && (int)spinner.getValue() >= 0) {
						SQLLiniesComanda.updateLiniaComanda(liniaComanda);
						baseDatosTablaComandasLinia();
					}else {
						System.out.println("valor del parametro incorrecto");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		btnNewButton.setBounds(12, 284, 126, 25);
		panel.add(btnNewButton);
		
		JButton btnRevisarxml = new JButton("revisarXML");
		btnRevisarxml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				baseDatosTablaComandas();
				revisarXml();
			}
		});
		btnRevisarxml.setBounds(12, 22, 126, 25);
		panel.add(btnRevisarxml);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void revisarXml() {
		
		//String idClient;
		//String idComanda;
		//String status;
		
		for(int x = 0; x< lectorXml.getArrayComandes().size(); x++) {
			
			
			try {
				SQLComandes.insertaComanda(new Comanda(lectorXml.getArrayComandes().get(x).getIdClient(),
						lectorXml.getArrayComandes().get(x).getIdComanda(),
						lectorXml.getArrayComandes().get(x).getStatus()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		
		
		
		for(int y = 0; y< lectorXml.getArrayLiniesComandes().size(); y++) {

	
					try {
						
						SQLLiniesComanda.insertaLiniaComanda(new LiniaComanda(lectorXml.getArrayLiniesComandes().get(y).getIdLiniaC(),
								lectorXml.getArrayLiniesComandes().get(y).getIdComanda(), 
								lectorXml.getArrayLiniesComandes().get(y).getIdArticle(), 
								lectorXml.getArrayLiniesComandes().get(y).getUnitatsDemanades(),
								lectorXml.getArrayLiniesComandes().get(y).getUnitatsServides(),
								lectorXml.getArrayLiniesComandes().get(y).getPreuLinia(),
								lectorXml.getArrayLiniesComandes().get(y).getEstat()));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
	}
	
	// ***********************************************************************************************************
	// *********************************************METODES*******************************************************
	// ***********************************************************************************************************


	String idComandaIndex = "";
	String filtro = "";
	
	
	
	
	
	public void baseDatosTablaComandas() {
		// DATA BASE

		SQLComandes datos = new SQLComandes();
		datos.conectar();

		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("idComanda");
		model.addColumn("idClient");
		model.addColumn("preu");
		model.addColumn("dataObertura");
		model.addColumn("dataFinalitzacio");
		model.addColumn("status");

		table.setModel(model);
		model.setRowCount(0);

		try {
			
			
			
			for (Comanda comanda : datos.consultaComanda("Comanda")) {
				switch (casoBoton) {
				case 0:
						model.addRow(new Object[] { comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getDataObertura(), comanda.getDataFinalitzacio(),comanda.getStatus()});
						break;
				case 1:
					
					if(comanda.getStatus().contains("0")) {
					model.addRow(new Object[] { comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getDataObertura(), comanda.getDataFinalitzacio(),comanda.getStatus()});
					}
					
					break;
				case 2:
					
					if(comanda.getStatus().contains("1")) {
						
						model.addRow(new Object[] { comanda.getIdComanda(), comanda.getIdClient(), comanda.getPreu(), comanda.getDataObertura(), comanda.getDataFinalitzacio(),comanda.getStatus()});
						}
					break;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		table.addMouseListener(new MouseAdapter() {

			
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 1) {
					System.out.println("Click!");
					final JTable jtable = (JTable) e.getSource();
					final int row = jtable.getSelectedRow();

					// obtenemos los valores selecionados i los guardamos en la variable
					idComandaIndex = (String) jtable.getValueAt(row, 0);
					baseDatosTablaComandasLinia();
					System.out.println(idComandaIndex);

				} else {
					System.out.println("Marca primer un registre");
				}
			}
		});
		
	}
	
	
	
	
	
	
	public void baseDatosTablaComandasLinia() {
		// DATA BASE
		
		SQLLiniesComanda datos = new SQLLiniesComanda();
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		datos.conectar();

			
		
		model.addColumn("idLiniaC");
		model.addColumn("idComanda");
		model.addColumn("idArticle");
		model.addColumn("unitatsDemanades");
		model.addColumn("unitatsServides");
		model.addColumn("preuLinia");
		model.addColumn("estat");

		table_1.setModel(model);
		model.setRowCount(0);
		

		
			try {
				
				for (LiniaComanda liniaComanda : datos.consultaLiniaComanda("LiniaComanda")) {
					
					if(liniaComanda.getIdComanda().contains(idComandaIndex)) {
						
						
						
						model.addRow(new Object[] { liniaComanda.getIdLiniaC(), liniaComanda.getIdComanda(), liniaComanda.getIdArticle(), liniaComanda.getUnitatsDemanades(), liniaComanda.getUnitatsServides(),liniaComanda.getPreuLinia(), liniaComanda.getEstat()});
						//System.out.println(liniaComanda.getIdLiniaC()+ liniaComanda.getIdComanda()+ liniaComanda.getIdArticle()+ liniaComanda.getUnitatsDemanades()+ liniaComanda.getUnitatsServides()+liniaComanda.getPreuLinia()+ liniaComanda.getEstat());
						
					};

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	
	int idLinia;
	String idComanda;
	int unitatsDemanades;
	
	
	
	public void actualizarUnidades() {
	
		table_1.addMouseListener(new MouseAdapter() {

			
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 1) {
					System.out.println("Click!");
					final JTable jtable = (JTable) e.getSource();
					final int row = jtable.getSelectedRow();

					// obtenemos los valores selecionados i los guardamos en la variable
					idLinia = (int) jtable.getValueAt(row, 0);
					idComanda = (String) jtable.getValueAt(row, 1);
					unitatsDemanades = (int) jtable.getValueAt(row, 3);
					spinner.setValue(jtable.getValueAt(row,4));
					
					
				} else {
					System.out.println("Marca primer un registre");
				}
			}
		});
		
	}
	

	
}
