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
	char statusComanda;
	String codi;
	String unitatsDemanades;
	String unitatsServides;
	String status;
	String preuUnitari;
	
	ArrayList<Comanda> LlistaComanda = new ArrayList<Comanda>();
	

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
				
				ArrayList<LiniaComanda> LiniesComanda = new ArrayList<LiniaComanda>();

				Node nNode = comandes.item(i);
				
				Element comandesElement = (Element) nNode;
				
				NodeList nList2 = comandes.item(i).getChildNodes();
				
				
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					for (int temp = 0; temp < nList2.getLength(); temp++) {		//bucle para recorrer cada articulo

						Node nNode2 = nList2.item(temp);
						// System.out.println("\nCurrent Element :" + nNode.getNodeName());
						
						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
							
							
							Element eElement = (Element) nNode2;
							
							
							codi = eElement.getElementsByTagName("codi").item(0).getTextContent();
							unitatsDemanades = eElement.getElementsByTagName("unitats").item(0).getTextContent();
							unitatsServides = eElement.getElementsByTagName("unitatsServides").item(0).getTextContent();
							status = eElement.getElementsByTagName("status").item(0).getTextContent();
							preuUnitari = eElement.getElementsByTagName("preuUnitari").item(0).getTextContent();

							LiniesComanda.add(new LiniaComanda(temp + 1/2, i + 1, codi,
									Integer.parseInt(unitatsDemanades), Integer.parseInt(unitatsServides),
									Float.parseFloat(preuUnitari), status.charAt(0)));

						}
						// llenamos el array linies comanda con los atributos del archivo xml

						
					}

					idClient = comandesElement.getAttribute("idclient");
					

				}
				
				if(comandesElement.getAttribute("status").equals("0")) {
					
					
					LlistaComanda.add(new Comanda(idClient, '0', LiniesComanda));
				}
				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIdClient() {
		return idClient;
	}

	public char getStatusComanda() {

		return statusComanda;
	}

	

	public ArrayList<Comanda> getArrayComandes() {
		return LlistaComanda;
	}
}