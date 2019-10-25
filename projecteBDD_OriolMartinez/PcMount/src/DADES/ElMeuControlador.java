package DADES;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ElMeuControlador extends DefaultHandler{


private int tab = 0;
	
	private void tabula() {
		for (int i=0; i<tab; i++)
			System.out.print("  ");
	}
		
	//Mètode de resposta a un esdeveniment de tipus 'Inici del document'
	@Override
	public void startDocument() {
		tabula();
		System.out.println("Inici del document XML");
		tab++;
	}

	//Mètode de resposta a un esdeveniment de tipus 'Fi del document'
	@Override
	public void endDocument() {
		tab--;
		tabula();
		System.out.println("Final del document XML");
	}
	
	//Mètode de resposta a un esdeveniment de tipus 'inici d'element'
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		tabula();
		System.out.print("Principi element: "+localName);
		if (attributes.getLength()>0) {
			System.out.print(" - Atributs: ");
			for (int i=0; i<attributes.getLength(); i++) {
				System.out.print(attributes.getLocalName(i)+": "+attributes.getValue(i));
			}
		}
		System.out.println();
		tab++;
	}
	
	//Mètode de resposta a un esdeveniment de tipus 'Fi de l'element'
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tab--;
		tabula();
		System.out.println("Final element: "+localName);
	}
	
	//Mètode de resposta a un esdeveniment de tipus 'caràcters dins d'element'
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String contingut = new String(ch, start, length);
		contingut = contingut.replaceAll("[\t\n]", "").trim();
		if (!contingut.equals("")) {
			tabula();
			System.out.println("Caràcters: "+contingut);
		}
	}
}

	
	
	
