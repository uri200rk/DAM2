package DADES;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import CLASSES.Comanda;



public class SQLComandes {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String idClient, idComanda, status, dataFinalitzacio;
	

	


	public Connection conectar() {

		try {

			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection("jdbc:sqlite:/home/oriol/pcMountDB");

			System.out.println("Exito al conectar con base de datos\n");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos\n");

		}
		return c;

	}

	public void updateStatus(Comanda comanda) {
		

		String sqlInsert = "UPDATE Comanda SET status =\""+comanda.getStatus()+
												"\""+" WHERE idComanda ="+"\""+comanda.getIdComanda()+"\";";
		
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
	
	public void updateFechaF(Comanda comanda) {
		String sqlInsert = "UPDATE Comanda SET dataFinalitzacio =\""+comanda.getDataFinalitzacio()+
				"\""+" WHERE idComanda ="+"\""+comanda.getIdComanda()+"\";";

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

	public void insertaComanda(Comanda comanda) throws SQLException {


		String sqlInsert = "INSERT INTO Comanda (idComanda, idClient, preu, dataObertura, dataFinalitzacio, status) "

		            	+ "VALUES ("+"\""+comanda.getIdComanda()+"\""+","
		            	+"\""+comanda.getIdClient()+"\""+","
		            	+"\""+comanda.getPreu()+"\""+"," 
		            	+"\""+comanda.getDataObertura()+"\""+"," 
		            	+"\""+comanda.getDataFinalitzacio()+"\""+"," 
		            	+"\""+comanda.getStatus()+"\""+");";

		

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
	
	
	
	public ArrayList<Comanda> consultaComanda(String nombreTabla) throws SQLException {

		
		ArrayList<Comanda> arrayComandes = new ArrayList<Comanda>();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";
		

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			
			
			
			
			while (rs.next()) {

				idClient = rs.getString("idClient");

			    idComanda = rs.getString("idComanda");

				status = rs.getString("status");
				
				dataFinalitzacio = rs.getString("dataFinalitzacio");
			
				
				
				//guardamos comanda en la arrayList
				
				arrayComandes.add(new Comanda(idClient,idComanda,status,dataFinalitzacio));
				
			}
			
			//mostramos comanda array
			System.out.println("Array Comandes:");
			for (int i = 0; i < arrayComandes.size(); i++) {
				
				System.out.println(arrayComandes.get(i));
			}

			rs.close();

			sentencia.close();

			c.close();

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		}
		return arrayComandes;

	}

}