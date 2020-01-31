package CLASSES;

public class MovimentsMagatzem{
	
	//atributs
	
	String idMoviment;
	String idArticle;
	String idComponent;
	int idMagatzem;
	Boolean tipusMoviment;
	int unitats;
	int ubicacioX;
	int ubicacioY;
	int ubicacioZ;
	

	
	public MovimentsMagatzem(String idMoviment, String idArticle, String idComponent, int idMagaztem, boolean tipusMoviment, int unitats, int ubicacioX, int ubicacioY, int ubicacioZ) {
		
		this.idMoviment = idMoviment;
		this.idArticle = idArticle;
		this.idComponent = idComponent;
		this.idMagatzem = idMagaztem;
		this.tipusMoviment = tipusMoviment;
		this.unitats = unitats;
		this.ubicacioX = ubicacioX;
		this.ubicacioY = ubicacioY;
		this.ubicacioZ = ubicacioZ;
	
		
	}
	
	//getters i setters
	
	public String getIdMoviment() {
		return idMoviment;
	}
	
	public void setIdMoviment(String idMoviment) {
		this.idMoviment = idMoviment;
	}
	
	public String getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	
	public String getIdComponent() {
		return idComponent;
	}
	
	public void setIdComponent(String idComponent) {
		this.idComponent = idComponent;
	}
	
	public int getIdMagatzem() {
		return idMagatzem;
	}
	
	public void setIdMagatzem(int idMagatzem) {
		this.idMagatzem = idMagatzem;
	}
	
	public Boolean getTipusMoviment() {
		return tipusMoviment;
	}
	
	public void setTipusMoviment(Boolean tipusMoviment) {
		this.tipusMoviment = tipusMoviment;
	}
	
	public int getUnitats() {
		return unitats;
	}
	
	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}
	
	public int getUbicacioX() {
		return ubicacioX;
	}
	
	public void setUbicacioX(int ubicacioX) {
		this.ubicacioX = ubicacioX;
	}
	
	public int getUbicacioY() {
		return ubicacioY;
	}
	
	public void setUbicacioY(int ubicacioY) {
		this.ubicacioY = ubicacioY;
	}
	
	public int getUbicacioZ() {
		return ubicacioZ;
	}
	
	public void setUbicacioZ(int ubicacioZ) {
		this.ubicacioZ = ubicacioZ;
	}
	
	
	//metodes
	
	
	
	
}