package Clases;



public class Gym {
	
	//Atributs
	
	String cif, adreça;
	int cp;
	
	
	
	//contructor

		public Gym(String cif, String adreça, int cp) {
			
			this.cif = cif;
			this.adreça = adreça;
			this.cp = cp;
			
		}

	//getters i setters


		public String getCif() {
			return cif;
		}



		public void setCif(String cif) {
			this.cif = cif;
		}



		public String getAdreça() {
			return adreça;
		}



		public void setAdreça(String adreça) {
			this.adreça = adreça;
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
			return "Gym [cif=" + cif + ", adreça=" + adreça + ", cp=" + cp + "]";
		}
	

	
}