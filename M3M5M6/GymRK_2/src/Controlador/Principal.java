package Controlador;

import java.sql.SQLException;

import Clases.Client;
import Dades.SQLClients;
import Dades.SQLFitxades;
public class Principal {

	public static void main(String[] args) throws SQLException {

		SQLClients conector = new SQLClients();
		SQLFitxades fitxades = new SQLFitxades();
		//conector.conectar();
		//conector.consultaClients("Client");
		//conector.insertaClients(new Client("5645","dfg","dfg","dfgf","dfg",151));
		// conector.updateClients(new
		// Client("235256137G","maria2","apellido2","prueba3@gmail.com","54646414165454",548565215,false,
		// true));
		//conector.deleteClients(new Client("3535256137G"));
		
		//fitxades.consultaFitxades("Fitxades");
		//conector.close();
		
		
	}

}