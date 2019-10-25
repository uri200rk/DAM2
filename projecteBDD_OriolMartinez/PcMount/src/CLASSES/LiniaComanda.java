package CLASSES;



public class LiniaComanda{
	
	
	//atributs

		int idLiniaC;
		int idComanda;
		String idArticle;
		int unitatsDemanades;
		int unitatsServides;
		float preuUnitari;
		char status;
		float preuLinia;
	
	//contructor
		
		public LiniaComanda(int idLiniaC, String idArticle, int unitatsDemanades, int unitatsServides, float preuUnitari, char status) {
			
			this.idLiniaC = idLiniaC;
			this.idComanda = 1;
			this.idArticle = idArticle;
			this.unitatsDemanades = unitatsDemanades;
			this.unitatsServides = unitatsDemanades;
			this.status = status; 
			this.preuUnitari = preuUnitari;
			this.preuLinia = unitatsDemanades * preuUnitari;
		}

	//getters i setters
		
		public int getIdLiniaC() {
			return idLiniaC;
		}
		
		public void setIdLiniaC(int idLiniaC) {
			this.idLiniaC = idLiniaC;
		}
		
		public int getIdComanda() {
			return idComanda;
		}
		
		public void setIdComanda(int idComanda) {
			this.idComanda = idComanda;
		}
		
		public String getIdArticle() {
			return idArticle;
		}
		
		public void setIdArticle(String idArticle) {
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
		
		public void setEstat(Boolean estat) {
			this.status = status;
		}
		
		public float getPreuLinia() {
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
					+ ", preuUnitari=" + preuUnitari + ", status=" + status + ", preuLinia=" + preuLinia + "]";
		}

		
		
			
		
	
}