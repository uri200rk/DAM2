package CONTROLADOR;

import CLASSES.Comanda;

import CLASSES.LiniaComanda;
import DADES.lectorXml;

public class Principal{
	
	public static void main(String[] args) {
		
	lectorXml lectura = new lectorXml();
	
	//creacio objecte comanda
	
	Comanda comanda = new Comanda(lectura.getIdClient(),lectura.getStatusComanda(),lectura.getArrayLiniesC());
	System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	
	//print comanda amb les seves linies comandes
	
	System.out.println("Comanda: "+comanda.toString()+"\n"+comanda.getLiniesComanda());
	

	}
		
	
}