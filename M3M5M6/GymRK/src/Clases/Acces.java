package Clases;



public class Acces {
	
	//Atributs
	
	int checkId;
	String dataHoraFitxada, dni, cif;
	Boolean tipus;
	
	
	
	
	//contructor

		public Acces(int checkId, String datatHoraFitxada, String dni, String cif, Boolean tipus) {
			
			this.checkId = checkId;
			this.dataHoraFitxada = datatHoraFitxada;
			this.dni = dni;
			this.cif = cif;
			this.tipus = tipus;
			

		}


	//getters i setters

		public int getCheckId() {
			return checkId;
		}




		public void setCheckId(int checkId) {
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




		public Boolean getTipus() {
			return tipus;
		}




		public void setTipus(Boolean tipus) {
			this.tipus = tipus;
		}

	//Metodes
		
		public static void claculTemps() {
			
		}
		
	//toString
		
		@Override
		public String toString() {
			return "Acces [checkId=" + checkId + ", dataHoraFitxada=" + dataHoraFitxada + ", dni=" + dni + ", cif="
					+ cif + ", tipus=" + tipus + "]";
		}
		
	
	
}