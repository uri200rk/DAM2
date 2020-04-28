package Clases;

public class Client {

	// Atributs

	String dni, nom, cognom, mail, iban, cifGym, statPagament, admin;
	int tlf;

	// contructor

	public Client(String dni, String nom, String cognom, String mail, String iban, int tlf, String statPagament,
			String admin, String cifGym) {

		this.dni = dni;
		this.nom = nom;
		this.cognom = cognom;
		this.mail = mail;
		this.iban = iban;
		this.tlf = tlf;
		this.statPagament = statPagament;
		this.admin = admin;
		this.cifGym = cifGym;

	}

	// second constructor

	public Client(String dni) {
		this.dni = dni;
	}
	
	//third constructor
	
	public Client(String dni, String nom, String cognom ,String mail, String iban, int tlf, String cifGym) {
		this.dni = dni; 
		this.nom = nom; 
		this.cognom = cognom;
		this.mail = mail;
		this.iban = iban;
		this.tlf = tlf;
		this.cifGym = cifGym;
	}

	// getters i setters

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getStatPagament() {
		return statPagament;
	}

	public void setStatPagament(String statPagament) {
		this.statPagament = statPagament;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getCifGym() {
		return cifGym;
	}
	public void setCifGym(String cifGym) {
		this.cifGym = cifGym;
	}
	
	// Metodes

	public static void updateStatPagament() {

	}

	// toString

	@Override
	public String toString() {
		return "Client [dni=" + dni + ", nom=" + nom + ", cognom=" + cognom + ", mail=" + mail + ", iban=" + iban
				+ ", tlf=" + tlf + ", statPagament=" + statPagament + ", admin=" + admin + "]";
	}

}