package CLASSES;

public class Client {
	
	
	
//atributs

		String cif;
		String nom;
		String cognom;
		String adreça;
		String  codiPostal;
		String tlf;
		String nBancari;
		
//contructor

		public Client(String cif, String nom, String cognom, String adreça, String codiPostal, String tlf, String nBancari) {
			
			this.cif = cif;
			this.nom = nom;
			this.cognom = cognom;
			this.adreça = adreça;
			this.codiPostal = codiPostal;
			this.tlf = tlf;
			this.nBancari = nBancari;
			
		}
//Segundo constructor
	public Client(String cif) {
			
			this.cif = cif;
				
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
	
	public String getCodiPostal() {
		return codiPostal;
	}
	
	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}
	
	public String getTlf() {
		return tlf;
	}
	
	public void setTlf(String tlf) {
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

	@Override
	public String toString() {
		return "Client [cif=" + cif + ", nom=" + nom + ", cognom=" + cognom + ", adreça=" + adreça + ", codiPostal="
				+ codiPostal + ", tlf=" + tlf + ", nBancari=" + nBancari + "]";
	}
	
	
	
	
	
	
}