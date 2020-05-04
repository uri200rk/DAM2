package Dades;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Clases.Client;
import Vistes.gestioAdmin;

public class SQLClients {

	
	Connection c;

	PreparedStatement st = null;

	ResultSet rs = null;

	String nombreTabla;

	String dni, nombre, apellidos, mail, iban, cifGym, statPagament, tUsuari;

	int tlf;

	String url;
	
	ArrayList<Client> arrayClients = new ArrayList<Client>();

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

		String sqlInsert = "INSERT INTO Client (DNI, Nom, Cognom, Mail, IBAN, Tlf, StatPagament, Admin, CifGym) "

				+ "VALUES (" + "\"" + Client.getDni() + "\"" + "," + "\"" + Client.getNom() + "\"" + "," + "\""
				+ Client.getCognom() + "\"" + "," + "\"" + Client.getMail() + "\"" + "," + "\"" + Client.getIban()
				+ "\"" + "," + "\"" + Client.getTlf() + "\"" + "," + "\"" + Client.getStatPagament() + "\"" + "," + "\""
				+ Client.getAdmin() + "\""+ "," + "\"" + Client.getCifGym() + "\"" + ");";
		
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

	public void updateClients(Client client) throws SQLException {

		String sqlUpdate = "UPDATE Client SET" + " DNI=\"" + client.getDni() + "\",Nom =\"" + client.getNom()
				+ "\",Cognom = \"" + client.getCognom() + "\",Mail =\"" + client.getMail() + "\",IBAN =\""
				+ client.getIban() + "\",Tlf =\"" + client.getTlf() + "\",StatPagament =\"" + client.getStatPagament()
				+ "\",Admin =\"" + client.getAdmin() + "\",CifGym =\"" + client.getCifGym() + "\"" + " WHERE DNI =" + "\"" + client.getDni() + "\"";
		System.out.println(sqlUpdate);
		System.out.println(client.getCifGym());

		try {

			conectar();

			st = c.prepareStatement(sqlUpdate);

			st.execute();

			st.close();
			close();

			System.out.println("Datos modificados");

		} catch (Exception e) {

			System.out.println("Error al modificar datos en la tabla");

		}

	}

	public void deleteClients(Client client) throws SQLException {

		String sqlDelete = "DELETE FROM Client WHERE DNI =" + "\"" + client.getDni() + "\"";
		System.out.println(
				"dni-------------------------------------------------------------------------------------------"
						+ client.getDni());

		try {

			conectar();

			st = c.prepareStatement(sqlDelete);

			st.execute();

			st.close();
			close();

			System.out.println("Datos borrados");

		} catch (Exception e) {

			System.out.println("Error al borrar datos en la tabla");

		}

	}

	public ArrayList<Client> consultaClients(String taula) {

		

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

				statPagament = rs.getString("StatPagament");

				tUsuari = rs.getString("Admin");
				
				cifGym = rs.getString("CifGym");

				System.out.println("[ Dni : \"" + dni + "\"\n  Nombre : \"" + nombre + "\" \n  Apellidos : \""
						+ apellidos + "\"\n  Mail: \"" + mail + "\"\n  IBAN: \"" + iban + "\"\n  Tlf: \"" + tlf
						+ "\"\n  StatPagament: \"" + statPagament + "\"\n  TipoUsuario: \"" + tUsuari + "\"]\n");

				// añadimos cliente a la array

				arrayClients.add(new Client(dni, nombre, apellidos, mail, iban, tlf, statPagament, tUsuari, cifGym));

			}

			// mostramos clientes array
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

	public Client consultaClientDNI(String taula, String dni) {
		try {
			System.out.println("select * from " + taula + " where dni = " + dni);
			st = c.prepareStatement("select * from " + taula + " where dni = " + dni);

			rs = st.executeQuery();

			while (rs.next()) {

				dni = rs.getString("DNI");

				nombre = rs.getString("Nom");

				apellidos = rs.getString("Cognom");

				mail = rs.getString("Mail");

				iban = rs.getString("IBAN");

				tlf = rs.getInt("Tlf");

				statPagament = rs.getString("StatPagament");

				tUsuari = rs.getString("Admin");
				
				cifGym = rs.getString("CifGym");


				System.out.println("[ Dni : \"" + dni + "\"\n  Nombre : \"" + nombre + "\" \n  Apellidos : \""
						+ apellidos + "\"\n  Mail: \"" + mail + "\"\n  IBAN: \"" + iban + "\"\n  Tlf: \"" + tlf
						+ "\"\n  StatPagament: \"" + statPagament + "\"\n  TipoUsuario: \"" + tUsuari + "\"]\n");

			}

			rs.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return new Client(dni, nombre, apellidos, mail, iban, tlf, statPagament, tUsuari, cifGym);

	}
	
	
	public ArrayList<Client> BuscarBuscador(Client client) throws SQLException {
        conectar();

        String consultaSql = "SELECT * FROM Client WHERE DNI LIKE '%" + client.getDni() + "%';";
		st = c.prepareStatement(consultaSql);

        try {

			rs = st.executeQuery();


            while (rs.next()) {

				dni = rs.getString("DNI");

				nombre = rs.getString("Nom");

				apellidos = rs.getString("Cognom");

				mail = rs.getString("Mail");

				iban = rs.getString("IBAN");

				tlf = rs.getInt("Tlf");

				statPagament = rs.getString("StatPagament");

				tUsuari = rs.getString("Admin");
				
				cifGym = rs.getString("CifGym");
				
                //GUARDA EN ARRAY LIST CLIENT
				arrayClients.add(new Client(dni, nombre, apellidos, mail, iban, tlf, statPagament, tUsuari, cifGym));

            }

            rs.close();
            st.close();
            c.close();

        } catch (Exception e) {
            System.out.println("fALLO AL BUSCAR ");

        }
        return arrayClients;
    }
    
	


}
