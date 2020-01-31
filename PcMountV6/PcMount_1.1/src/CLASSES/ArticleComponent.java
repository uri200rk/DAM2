package CLASSES;


public class ArticleComponent{
	
	
	
	//atributs
	
	String idArticleC;
	String idArticle;
	String idComponent;
	
	
	
	public ArticleComponent(String idArticleC, String idArticle, String idComponent) {
		
		this.idArticleC = idArticleC;
		this.idArticle = idArticle;
		this.idComponent = idComponent;
		
				
	}
	
	
	//getters i setters
	
	
	public String getIdArticleC() {
		return idArticleC;
	}
	
	public void setIdArticleC(String idArticleC) {
		this.idArticleC = idArticleC;
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
	
	
	//metodes
	
	public void addArtComponent(String article, String component) {
		
	}
	
	
	public void delArtComponent(String article, String component) {
		
	}
	
	
	
	
}
