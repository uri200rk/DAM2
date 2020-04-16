package Dades;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import Clases.Client;


public class SQLClients {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String cif, Nombre, Apellidos, adreca, nBancari, tlf, codiPostal;
	
	String url;
	


	public Connection conectar() {

		url = "D:\\Programas\\BD\\gym";
		
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

/*
	public void insertaClients(Client client) throws SQLException {


		String sqlInsert = "INSERT INTO Clients (cif, nom, cognom, adreça, codiPostal, tlf, nBancari) "

		            	+ "VALUES ("+"\""+client.getCif()+"\""+","
		            	+"\""+client.getNom()+"\""+","
		            	+"\""+client.getCognom()+"\""+"," 
		            	+"\""+client.getAdreça()+"\""+"," 
		            	+"\""+client.getCodiPostal()+"\""+"," 
		            	+"\""+client.getTlf()+"\""+"," 
		            	+"\""+client.getnBancari()+"\""+");";

		

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos insertados");

		} catch (Exception e) {

			System.out.println("Error al insertar datos en la tabla");

		}

	}
	
	
	public void updateClients(Client client) throws SQLException {


		String sqlInsert = "UPDATE Clients SET"+" nom=\""+client.getNom()+
												"\",cognom =\""+client.getCognom()+
												"\",adreça = \""+client.getAdreça()+
												"\",codiPostal =\""+client.getCodiPostal()+
												"\",tlf =\""+client.getTlf()+
												"\",nBancari =\""+client.getnBancari()+
												"\""+" WHERE cif ="+"\""+client.getCif()+"\"";

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);
			System.out.println(sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos modificados");

		} catch (Exception e) {

			System.out.println("Error al modificar datos en la tabla");

		}

	}
	
	public void deleteClients(Client client) throws SQLException {


		String sqlInsert = "DELETE FROM clients WHERE cif ="+"\""+client.getCif()+"\"";
		

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos borrados");

		} catch (Exception e) {

			System.out.println("Error al borrar datos en la tabla");

		}

	}
	


	public ArrayList<Client> consultaClients(String nombreTabla) throws SQLException {

		//conectar();
		
		
		ArrayList<Client> arrayClients = new ArrayList<Client>();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			System.out.println("Visualització dels clients: \n");
			
			
			
			while (rs.next()) {

				cif = rs.getString("cif");

			    Nombre = rs.getString("nom");

				Apellidos = rs.getString("cognom");

				adreça = rs.getString("adreça");
				
				codiPostal = rs.getString("codiPostal");
				
				tlf = rs.getString("tlf");
				
				nBancari = rs.getString("nBancari");
				
				
				System.out.println("[ Nombre : \"" + Nombre + "\" \n  Apellidos : \"" + Apellidos + "\"\n  Adreça: \""+ adreça +"\"\n  Codi postal: \""+ codiPostal + "\"\n  Tlf: \"" + tlf + "\"\n  nBancari: \"" + nBancari + "\"]\n");
				
				//guardamos clientes en la arrayList
				
				arrayClients.add(new Client(cif, Nombre, Apellidos, adreça, codiPostal, tlf, nBancari));
				
			}
			
			//mostramos clientes array
			System.out.println("Array Clientes:");
			for (int i = 0; i < arrayClients.size(); i++) {
				
				System.out.println(arrayClients.get(i));
			}

			rs.close();

			sentencia.close();

			c.close();

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		}
		return arrayClients;
*/
	}
	
	
	

