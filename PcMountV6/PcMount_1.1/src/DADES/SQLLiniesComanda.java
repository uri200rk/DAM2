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


public class SQLLiniesComanda {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String idComanda, status;
	
	int idLinia, idArticle, unitatsDemanades, unitatsServides;
	
	double preuLinia;
	

	


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
	
	
	
	public ArrayList<LiniaComanda> consultaLiniaComanda(String nombreTabla) throws SQLException {

		
		ArrayList<LiniaComanda> arrayLiniesComandes = new ArrayList<LiniaComanda>();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";
		System.out.println("consultaSql"+consultaSql);

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			System.out.println("Visualització de les Linies comandes: \n");
						
			
			while (rs.next()) {

				idLinia = rs.getInt("idLinia");

			    idComanda = rs.getString("idComanda");

				idArticle = rs.getInt("idArticle");
				
				unitatsDemanades = rs.getInt("unitatsDemanades");
				
				unitatsServides = rs.getInt("unitatsServides");
				System.out.println("uniadesServides"+unitatsServides);
				
				preuLinia = rs.getDouble("preuLinia");
				
				status = rs.getString("status");
			
				
				//System.out.println("[ Nombre : \"" + Nombre + "\" \n  Apellidos : \"" + Apellidos + "\"\n  Adreça: \""+ adreça +"\"\n  Codi postal: \""+ codiPostal + "\"\n  Tlf: \"" + tlf + "\"\n  nBancari: \"" + nBancari + "\"]\n");
				
				//guardamos liniesComanda en la arrayList
				
				arrayLiniesComandes.add(new LiniaComanda(idLinia,idComanda, idArticle, unitatsDemanades, unitatsServides, preuLinia, status));
				System.out.println("array "+idLinia+idComanda+idArticle+ unitatsDemanades+ unitatsServides+ preuLinia+ status);
				
			}
			
			//mostramos liniesComandes array
			System.out.println("Array Comandes:");
			for (int i = 0; i < arrayLiniesComandes.size(); i++) {
				
				System.out.println(arrayLiniesComandes.get(i));
			}

			rs.close();

			sentencia.close();

			c.close();

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		}
		return arrayLiniesComandes;

	}

}