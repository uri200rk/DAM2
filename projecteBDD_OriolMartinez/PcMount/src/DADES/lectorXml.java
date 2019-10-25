package DADES;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import CLASSES.LiniaComanda;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class lectorXml {

	String idClient;
	String statusComanda;
	String codi;
	String unitatsDemanades;
	String unitatsServides;
	String status;
	String preuUnitari;
	ArrayList <LiniaComanda> LiniesComanda = new ArrayList <LiniaComanda>();
	
   public lectorXml() {

      try {
         File inputFile = new File("comanda.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         idClient = doc.getDocumentElement().getAttribute("idclient");
         System.out.println("Id client : " + idClient);
         
         statusComanda = doc.getDocumentElement().getAttribute("status");
         NodeList nList = doc.getElementsByTagName("article");
         
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
                            
               //obtencio CODI
               System.out.println("Codi: " 
                  + eElement
                  .getElementsByTagName("codi")
                  .item(0)
                  .getTextContent());
               	
               		
               
               //obtencio UNITATS
               System.out.println("Unitats: " 
                  + eElement
                  .getElementsByTagName("unitats")
                  .item(0)
                  .getTextContent());
             
               
               //rellenamos el constructor de linia comanda, con la array
               codi = eElement.getElementsByTagName("codi").item(0).getTextContent();
               unitatsDemanades = eElement.getElementsByTagName("unitats").item(0).getTextContent();
               unitatsServides = eElement.getElementsByTagName("unitatsServides").item(0).getTextContent();
               status = eElement.getElementsByTagName("status").item(0).getTextContent();
               preuUnitari = eElement.getElementsByTagName("preuUnitari").item(0).getTextContent();
               
               //llenamos el array con los atributos del archivo xml
               
               LiniesComanda.add(new LiniaComanda(temp+1,codi,Integer.parseInt(unitatsDemanades),Integer.parseInt(unitatsServides),Float.parseFloat(preuUnitari), status.charAt(0)));
               
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
	return statusComanda.charAt(0);
   }
   
   public ArrayList<LiniaComanda> getArrayLiniesC() {
	   
	   return LiniesComanda;
   }
   
   
   
}