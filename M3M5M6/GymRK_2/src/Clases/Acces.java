package Clases;

import java.sql.Date;

public class Acces {

	// Variables
	
	String checkId, dataHoraFitxada, dni, cif, tipus;

	// contructor

	public Acces(String datatHoraFitxada, String tipus, String dni, String cif) {

		this.dataHoraFitxada = datatHoraFitxada;
		this.tipus = tipus;
		this.dni = dni;
		this.cif = cif;

	}
	
	// secnond contructor

	public Acces(String checkID, String datatHoraFitxada, String tipus, String dni, String cif) {

		this.checkId = checkID;
		this.dataHoraFitxada = datatHoraFitxada;
		this.tipus = tipus;
		this.dni = dni;
		this.cif = cif;

	}

	// getters i setters

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getDataHoraFitxada() {
		return dataHoraFitxada;
	}

	public void setDataHoraFitxada(String dataHoraFitxada) {
		this.dataHoraFitxada = dataHoraFitxada;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	// Metodes

	public static void claculTemps() {

	}

	// toString

	@Override
	public String toString() {
		return "Acces [dataHoraFitxada=" + dataHoraFitxada + ", dni=" + dni + ", cif=" + cif + ", tipus=" + tipus + "]";
	}

}