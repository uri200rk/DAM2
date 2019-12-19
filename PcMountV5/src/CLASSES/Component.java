package CLASSES;



public class Component{
	
	
	//atributs
	
	String idComponent;
	String tipus;
	String descripcio;
	double preu;
	String marca;
	
	
	public Component(String idComponent, String tipus, String descripcio, double preu, String marca){
		
		
		this.idComponent = idComponent;
		this.tipus = tipus; 
		this.descripcio = descripcio; 
		this.preu = preu;
		this.marca = marca;
		
		
		
	}
	
	
	//getters i setters
	
	public String getIdComponent() {
		return idComponent;
	}
	
	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}
	
	public String getTipus() {
		return tipus;
	}
	
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	public double getPreu() {
		return preu;
	}
	
	public void setPreu(double preu) {
		this.preu = preu;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	

	
	
}


