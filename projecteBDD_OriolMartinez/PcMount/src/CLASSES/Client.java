package CLASSES;

public class Client {
	
	
	
//atributs

		String cif;
		String nom;
		String cognom;
		String adreça;
		int codiPostal;
		int tlf;
		String nBancari;
		
//contructor

		public Client(String cif, String nom, String cognom, String adreça, int codiPostal, int tlf, String nBancari) {
			
			this.cif = cif;
			this.nom = nom;
			this.cognom = cognom;
			this.adreça = adreça;
			this.codiPostal = codiPostal;
			this.tlf = tlf;
			this.nBancari = nBancari;
			
		}
	
//metodes getters i setters

	
	public String getCif() {
		return cif;
	} 
	
	public void setCif(String cif) {
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
	
	public int getCodiPostal() {
		return codiPostal;
	}
	
	public void setCodiPostal(int codiPostal) {
		this.codiPostal = codiPostal;
	}
	
	public int getTlf() {
		return tlf;
	}
	
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	
	public String getnBancari() {
		return nBancari;
	}
	
	public void setnBancari(String nBancari) {
		this.nBancari = nBancari;
	}
	
	
//metodes
	
	public void pagament() {
		
		
	}
	
	
	
	
	
	
}