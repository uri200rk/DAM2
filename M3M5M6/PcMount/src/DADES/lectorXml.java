package DADES;


import java.io.File;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import CLASSES.Comanda;
import CLASSES.LiniaComanda;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class lectorXml {

	String idClient;
	String statusComanda;
	int codi;
	String unitatsDemanades;
	String unitatsServides;
	char status;
	String preuUnitari = "4";
	String idComanda;
	Comanda comanda;
	Integer idLiniaContador = 0;
	int idLinia;
	
	
	
	ArrayList<Comanda> LlistaComanda = new ArrayList<Comanda>();
	ArrayList<Comanda> ArrayComandes = new ArrayList<Comanda>();
	ArrayList<LiniaComanda> ArrayLiniesComandes = new ArrayList<LiniaComanda>();
	
	SQLArticles SQLArticles = new SQLArticles();
	
	

	public lectorXml() {
		
		

		try {
			File inputFile = new File("comanda.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// statusComanda = doc.getDocumentElement().getAttribute("status");
			NodeList comandes = doc.getElementsByTagName("comanda");
			
			
			//System.out.println("----------------------------");

			for (int i = 0; i < comandes.getLength(); i++) {		//bucle para recorrer cada comanda
				
				//ArrayList<LiniaComanda> LiniesComanda = new ArrayList<LiniaComanda>();
				

				Node nNode = comandes.item(i);
				
				Element comandesElement = (Element) nNode;
				
				NodeList nList2 = comandes.item(i).getChildNodes();
				
				idLinia = 0;
				
				idClient = comandesElement.getAttribute("idclient");
				statusComanda = comandesElement.getAttribute("status");
				idComanda = comandesElement.getAttribute("idComanda");
				
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					for (int temp = 0; temp < nList2.getLength(); temp++) {		//bucle para recorrer cada articulo
						
						Node nNode2 = nList2.item(temp);
						// System.out.println("\nCurrent Element :" + nNode.getNodeName());
						
						
						
						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
							idLinia++;
							
							Element eElement = (Element) nNode2;
							
						
							codi = Integer.parseInt(eElement.getElementsByTagName("codi").item(0).getTextContent());
							unitatsDemanades = eElement.getElementsByTagName("unitats").item(0).getTextContent();
							unitatsServides = eElement.getElementsByTagName("unitatsServides").item(0).getTextContent();
							status = eElement.getElementsByTagName("status").item(0).getTextContent().charAt(0);
							
							
					
							ArrayLiniesComandes.add(new LiniaComanda(idLinia, idComanda, codi, Integer.parseInt(unitatsDemanades), Integer.parseInt(unitatsServides), SQLArticles.consultaArticles(codi)*Integer.parseInt(unitatsDemanades), status));
							

						}
						// llenamos el array linies comanda con los atributos del archivo xml

						
					}

					
					
					

				}
				
				if(comandesElement.getAttribute("status").equals("0")) {
					
					
					//LlistaComanda.add(new Comanda(idClient, "0", LiniesComanda));
					
					ArrayComandes.add(new Comanda(idClient,idComanda,statusComanda,null));
					
					
				}
				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIdClient() {
		return idClient;
	}

	public String getStatusComanda() {

		return statusComanda;
	}
	
	public ArrayList<Comanda>getArrayComandes(){
		
		return ArrayComandes;
	}
	
	public ArrayList<LiniaComanda>getArrayLiniesComandes(){
		return ArrayLiniesComandes;
	}

	

	public ArrayList<Comanda> getLListaComanda() {
		return LlistaComanda;
	}
}