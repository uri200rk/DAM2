package CONTROLADOR;

import java.sql.SQLException;

import CLASSES.Client;
import DADES.SQLClients;


import DADES.lectorXml;

public class Principal {

	public static void main(String[] args) throws SQLException {

		lectorXml lectura = new lectorXml();
		SQLClients conector = new SQLClients();
		conector.conectar();
		conector.consultaClients("Clients");
		conector.insertaClients(new Client("26252123","Mariona","Calabró","tierra 32","57584","478569852","214523652152"));
		conector.updateClients(new Client("54853215Y", "nom", "prueba","barceloneta","43433","526735230","43956230572396"));
		conector.deleteClients("262521tt");
	
		System.out.println(lectura.getArrayComandes());


	}

}