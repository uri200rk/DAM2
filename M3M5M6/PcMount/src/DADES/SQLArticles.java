package DADES;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import CLASSES.Client;
import CLASSES.Comanda;
import CLASSES.LiniaComanda;
import DADES.lectorXml;
import VISTA.frmComandes;


public class SQLArticles {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String descripcio;
	
	char status;
	
	int idArticle, unitats;
	
	Double preu;
	
	
	

	


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

	/*

	public void insertaLiniaComanda(LiniaComanda liniaComanda) throws SQLException {


		String sqlInsert = "INSERT INTO LiniaComanda (idLinia, idComanda, idArticle, unitatsDemanades, unitatsServides, preuLinia ,status) "

		            	+ "VALUES ("+"\""+liniaComanda.getIdLiniaC()+"\""+","
		            	+"\""+liniaComanda.getIdComanda()+"\""+","
		            	+"\""+liniaComanda.getIdArticle()+"\""+"," 
		            	+"\""+liniaComanda.getUnitatsDemanades()+"\""+"," 
		            	+"\""+liniaComanda.getUnitatsServides()+"\""+","
		            	+"\""+liniaComanda.getPreuLinia()+"\""+"," 
		            	+"\""+liniaComanda.getEstat()+"\""+");";

		

		try {

			conectar();

			sentencia = c.createStatement();

			sentencia.executeUpdate(sqlInsert);
			System.out.println("sqlInsertLinia:"+sqlInsert);

			sentencia.close();

			c.close();

			System.out.println("Datos insertados");

		} catch (Exception e) {

			System.out.println("Error al insertar datos en la tabla");

		}

	}
	
	
	public void updateLiniaComanda(LiniaComanda liniaComanda) throws SQLException {
	

		String sqlInsert = "UPDATE LiniaComanda SET unitatsServides =\""+liniaComanda.getUnitatsServides()+
												"\""+" WHERE idLinia ="+"\""+liniaComanda.getIdLiniaC()+"\" AND idComanda =\""+liniaComanda.getIdComanda() + "\";";
		
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
	*/

	
	public double consultaArticles(int codi) throws SQLException {
		System.out.println(codi);
		double preu = 0.0;
		//ArrayList<LiniaComanda> arrayLiniesComandes = new ArrayList<LiniaComanda>();
		conectar();
		sentencia = c.createStatement();

		String consultaSql = "SELECT preuTotal FROM Articles WHERE idArticle = '"+ codi+"';";
		System.out.println("consultaSql"+consultaSql);

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			System.out.println("Visualització de les Linies comandes: \n");
						
			
			while (rs.next()) {

				
				preu = rs.getDouble("preuTotal");
				
				
				
			}
			
			
			
			
			rs.close();

			sentencia.close();

			c.close();

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		}
		return preu;

	}

}