package Dades;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Clases.Client;

public class SQLClients {

	Connection c;

	PreparedStatement st = null;

	ResultSet rs = null;

	String nombreTabla;

	String dni, nombre, apellidos, mail, iban;
	
	int tlf;
	
	Boolean statPagament, admin;

	String url;

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

	public void insertaClients(Client Client) {

		String sqlInsert = "INSERT INTO Client (DNI, Nom, Cognom, Mail, IBAN, Tlf, StatPagament, Admin) "

				+ "VALUES (" + "\"" + Client.getDni() + "\"" + "," + "\"" + Client.getNom() + "\"" + "," + "\""
				+ Client.getCognom() + "\"" + "," + "\"" + Client.getMail() + "\"" + "," + "\"" + Client.getIban()
				+ "\"" + "," + "\"" + Client.getTlf() + "\"" + "," + "\"" + Client.getStatPagament() + "\"" + "," + "\""
				+ Client.getAdmin() + "\"" + ");";

		try {

			st = c.prepareStatement(sqlInsert);

			st.execute();

			st.close();
			c.close();

			System.out.println("Datos insertados correctamente");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			System.out.println("Error al insertar los datos");
		}

	}

	public void updateClients(Client client) throws SQLException {

		String sqlUpdate = "UPDATE Client SET" + " DNI=\"" + client.getDni() + "\",Nom =\"" + client.getNom()
				+ "\",Cognom = \"" + client.getCognom() + "\",Mail =\"" + client.getMail() + "\",IBAN =\""
				+ client.getIban() + "\",Tlf =\"" + client.getTlf() + "\",StatPagament =\"" + client.getStatPagament()
				+ "\",Admin =\"" + client.getAdmin() + "\"" + " WHERE DNI =" + "\"" + client.getDni() + "\"";

		try {

			st = c.prepareStatement(sqlUpdate);

			st.execute();

			st.close();
			c.close();

			System.out.println("Datos modificados");

		} catch (Exception e) {

			System.out.println("Error al modificar datos en la tabla");

		}

	}

	public void deleteClients(Client client) throws SQLException {

		String slqDelete = "DELETE FROM Client WHERE DNI =" + "\"" + client.getDni() + "\"";

		try {

			st = c.prepareStatement(slqDelete);

			st.execute();

			st.close();
			c.close();

			System.out.println("Datos borrados");

		} catch (Exception e) {

			System.out.println("Error al borrar datos en la tabla");

		}

	}

	public ArrayList<Client> consultaClients(String taula) {
		
		ArrayList<Client> arrayClients = new ArrayList<Client>();


		try {
			st = c.prepareStatement("select * from " + taula);
			rs = st.executeQuery();

			while (rs.next()) {

				dni = rs.getString("DNI");

				nombre = rs.getString("Nom");

				apellidos = rs.getString("Cognom");

				mail = rs.getString("Mail");

				iban = rs.getString("IBAN");

				tlf = rs.getInt("Tlf");

				statPagament = rs.getBoolean("StatPagament");

				admin = rs.getBoolean("Admin");

				System.out.println("[ Dni : \"" + dni + "\"\n  Nombre : \"" + nombre + "\" \n  Apellidos : \""
						+ apellidos + "\"\n  Mail: \"" + mail + "\"\n  IBAN: \"" + iban + "\"\n  Tlf: \"" + tlf
						+ "\"\n  StatPagament: \"" + statPagament + "\"\n  TipoUsuario: \"" + admin + "\"]\n");
				
				//añadimos cliente a la array
				
				arrayClients.add(new Client(dni, nombre, apellidos, mail, iban, tlf, statPagament, admin));

			}
			
			//mostramos clientes array
			System.out.println("Array Clientes:");
			for (int i = 0; i < arrayClients.size(); i++) {
				
				System.out.println(arrayClients.get(i));
			}


			rs.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
		return arrayClients;
	}

}
