package Dades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Clases.Acces;
import Clases.Client;

public class SQLFitxades {

	// objectos
	SQLClients conexion = new SQLClients();
	

	// conexion
	Connection c;
	PreparedStatement st = null;
	ResultSet rs = null;
	String url;

	// variables

	String checkID, dni, dataHoraFitxada, cif, tipus;

	// conexion
	public Connection conectar() {

		url = "D:\\Programas\\BD\\gymRK\\gymRK_BD.db";

		try {

			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection("jdbc:sqlite:" + url);

			System.out.println("Exito al conectar con base de datos\n");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos\n");
			e.printStackTrace();

		}
		return c;

	}
	
	public void close() {
		try {
			c.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}


	// consulta fitxades
	public ArrayList<Acces> consultaFitxades(String taula, String dni) {
		System.out.println("---------------------------" + taula);
		conectar();
		ArrayList<Acces> arrayFitxades = new ArrayList<Acces>();
		System.out.println("select * from " + taula + " where dni = " + dni);

		try {
			st = c.prepareStatement("select * from " + taula + " where dni = " + dni);
			rs = st.executeQuery();

			while (rs.next()) {

				// dataHoraFitxada = rs.getDate("DataHoraFitxada");
				checkID =  rs.getString("FitxadesID");

				dataHoraFitxada = rs.getString("dataHoraFitxada");

				tipus = rs.getString("Tipus");

				dni = rs.getString("dni");

				cif = rs.getString("cif");

				// añadimos fixada a la array

				arrayFitxades.add(new Acces(checkID, dataHoraFitxada, tipus, dni, cif));

			}

			// mostramos clientes array
			System.out.println("Array Fitxadas:");
			for (int i = 0; i < arrayFitxades.size(); i++) {

				System.out.println(arrayFitxades.get(i));
			}

			rs.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return arrayFitxades;
	}
	
	
	//insertar fitxada
	public void insertaFitxada(Acces acces) {

		
		String sqlInsert = "INSERT INTO Fitxades (DataHoraFitxada, Tipus, DNI, CIF) "

				+ "VALUES (" + "\"" + acces.getDataHoraFitxada() + "\"" + "," + "\""
				+ acces.getTipus()+ "\"" + "," + "\"" + acces.getDni() + "\"" + "," + "\"" + acces.getCif() + "\"" + ");";
		System.out.println(sqlInsert);

		try {
			
			conectar();

			st = c.prepareStatement(sqlInsert);

			st.execute();

			st.close();
			
			close();


			System.out.println("Datos insertados correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al insertar los datos");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}