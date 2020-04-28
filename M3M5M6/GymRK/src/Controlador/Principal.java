package Controlador;

import java.sql.SQLException;

import Clases.Client;
import Dades.SQLClients;

public class Principal {

	public static void main(String[] args) throws SQLException {

		SQLClients conector = new SQLClients();
		conector.conectar();
		conector.consultaClients("Client");
		//conector.insertaClients(new Client("6535256137G","pedro","apellido","prueba2@gmail.com","12226412364122",856321524,false,true));
		// conector.updateClients(new
		// Client("235256137G","maria2","apellido2","prueba3@gmail.com","54646414165454",548565215,false,
		// true));
		// conector.deleteClients(new Client("235256137G"));

		conector.close();

	}

}