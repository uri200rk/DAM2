package CLASSES;

public class Proveidors{
	
	
	//atributs
	
	int cif;
	String nom;
	String cognom;
	String adreça;
	int tlf;
	
	
	public Proveidors(int cif, String nom, String cognom, String adreça, int tlf) {
		
		this.cif = cif;
		this.nom = nom; 
		this.cognom = cognom; 
		this.adreça = adreça;
		this.tlf = tlf;
		
	}
	
	
	
	//getters i setters
	
	
	public int getCif() {
		return cif;
	}
	
	public void setCif(int cif) {
		this.cif = cif;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCognom() {
		return cognom;
	}
	
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public String getAdreça() {
		return adreça;
	}
	
	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}
	
	public int getTlf() {
		return tlf;
	}
	
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	
		
	
	
}