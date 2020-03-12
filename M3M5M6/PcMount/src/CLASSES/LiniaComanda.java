package CLASSES;



public class LiniaComanda{
	
	
	//atributs

		int idLiniaC;
		String idComanda;
		int idArticle;
		int unitatsDemanades;
		int unitatsServides;
		char status;
		double preuLinia;
	
	//contructor
		
		public LiniaComanda(int idLiniaC,String idComanda, int idArticle ,int unitatsDemanades, int unitatsServides, double preuLinia, char status) {
			
			this.idLiniaC = idLiniaC;
			this.idComanda = idComanda;
			this.idArticle = idArticle;
			this.unitatsDemanades = unitatsDemanades;
			this.unitatsServides = unitatsServides;
			this.status = status; 
			this.preuLinia = preuLinia;
		}
		
		public LiniaComanda(int idLiniaC, String idComanda) {
			this.idLiniaC = idLiniaC;
			this.idComanda = idComanda;
		}

	//getters i setters
		
		public int getIdLiniaC() {
			return idLiniaC;
		}
		
		public void setIdLinia(int idLiniaC) {
			this.idLiniaC = idLiniaC;
		}
		
		public String getIdComanda() {
			return idComanda;
		}
		
		public void setIdComanda(String idComanda) {
			this.idComanda = idComanda;
		}
		
		public int getIdArticle() {
			return idArticle;
		}
		
		public void setIdArticle(int idArticle) {
			this.idArticle = idArticle;
		}
		
		public int getUnitatsDemanades() {
			return unitatsDemanades;
		}
		
		public void setUnitatsDemanades(int unitats) {
			this.unitatsDemanades = unitats;
		}
		
		public int getUnitatsServides() {
			return unitatsServides;
		}
		
		public void setUnitatsServides(int unitatsServides) {
			this.unitatsServides = unitatsServides;
		}
		
		public char getEstat() {
			return status;
		}
		
		public void setEstat(char status) {
			this.status = status;
		}
		
		public double getPreuLinia() {
			return preuLinia;
		}
		
		
	
	
	//metodes
		
		public void calcularPreuLinia() {
			
		}
		
		public void comprovaStocks() {
			
		}
		
		public void comprovarStocksComponents() {
			
		}
		
		public void llançaOf() {
			
		}

	
		public String toString() {
			return "\nLiniaComanda [idLiniaC=" + idLiniaC + ", idComanda=" + idComanda + ", idArticle=" + idArticle
					+ ", unitatsDemanades=" + unitatsDemanades + ", unitatsServides=" + unitatsServides
					+ ", preuUnitari=" + ", status=" + status + ", preuLinia=" + preuLinia + "]";
		}

		
		
			
		
	
}