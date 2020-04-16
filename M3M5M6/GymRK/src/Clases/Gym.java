package Clases;



public class Gym {
	
	//Atributs
	
	String cif, adreca;
	int cp;
	
	
	
	//contructor

		public Gym(String cif, String adreca, int cp) {
			
			this.cif = cif;
			this.adreca = adreca;
			this.cp = cp;
			
		}

	//getters i setters


		public String getCif() {
			return cif;
		}



		public void setCif(String cif) {
			this.cif = cif;
		}



		public String getAdreca() {
			return adreca;
		}



		public void setAdreca(String adreca) {
			this.adreca = adreca;
		}



		public int getCp() {
			return cp;
		}



		public void setCp(int cp) {
			this.cp = cp;
		}
		
	//Metodes
		
		public static void udpateClient() {
			
		}
		
		public static void deleteClient() {
			
		}
		
		public static void insertClient() {
			
		}
		
	//toString

		@Override
		public String toString() {
			return "Gym [cif=" + cif + ", adreça=" + adreca + ", cp=" + cp + "]";
		}
	

	
}