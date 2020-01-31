package CLASSES;


public class Articles{
	
	
	//atributs
	
	
	String idArticle;
	String descripcio;
	int unitats;
	double preuTotal;
	
	
	public Articles(String idArticle, String descripcio, int unitats, float preuTotal) {
		
		this.idArticle = idArticle;
		this.descripcio = descripcio;
		this.unitats = unitats;
		this.preuTotal = preuTotal;
				
		
	}
	
	
	//getters i setters
	
	public String getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	public int getUnitats() {
		return unitats;
	}
	
	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}
	
	public double getPreuTotal() {
		return preuTotal;
	}
	
	public void setPreuTotal(float preuTotal) {
		this.preuTotal = preuTotal;
	}
	
	//metodes
	
	
	public void consultaComponents(String Articles) {
		
	}
	
	public void llistaDeComponents() {
		
	}
	
	
	
	
}