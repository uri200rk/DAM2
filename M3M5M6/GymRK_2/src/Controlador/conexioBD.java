package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexioBD {
	
	//variables
	
	Connection c;
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

}