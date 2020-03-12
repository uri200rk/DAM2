package CLASSES;


public class OrdreFabricacio {
	
	
	//atributs
	
	int idLiniaC;
	String idComanda; 
	String  idArticle;
	int unitats;
	Boolean estat;
	
	
	
	public OrdreFabricacio(int idLiniaC, String idComanda, String idArticle, int unitats, boolean estat) {
		
		this.idLiniaC = idLiniaC;
		this.idComanda = idComanda;
		this.idArticle = idArticle;
		this.unitats = unitats;
		this.estat = estat;
	}
	
	
	//getters i setters
	
	
	public int getIdLiniaC() {
		return idLiniaC;
	}
	
	public void setIdLiniaC(int idLiniaC) {
		this.idLiniaC = idLiniaC;
	}
	
	public String getIdComanda() {
		return idComanda;
	}
	
	public void setIdComanda(String idComanda) {
		this.idComanda = idComanda;
	}
	
	public String getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	
	public int getUnitats() {
		return unitats;
	}
	
	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}
	
	public Boolean getEstat() {
		return estat;
	}
	
	public void setEstat(Boolean estat) {
		this.estat = estat;
	}
	
	
	//metodes
	
	
	public void canviEstatOf() {
		
	}
	
	
	
	
}