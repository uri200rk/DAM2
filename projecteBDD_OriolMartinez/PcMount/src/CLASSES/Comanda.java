package CLASSES;

import java.util.ArrayList;
import java.util.Date;

public class Comanda {
	
	
	
//atributs

		int idComanda;
		String idClient;
		float preu;
		Date dataObertura;
		Date dataFinalitzacio;
		char status;
		ArrayList <LiniaComanda> LiniesComanda = new ArrayList <LiniaComanda>();
		
		
//contructor

		public Comanda(String idClient, char status, ArrayList<LiniaComanda> liniesComanda) {
			
			this.idComanda = 1;
			this.idClient = idClient;
			this.dataObertura = new Date ();
			this.dataFinalitzacio = null;
			this.status = status;
			this.LiniesComanda = liniesComanda;	
			
		}
	
//metodes getters i setters
		
		public int getIdComanda() {
			return idComanda;
		}
		
		public void setIdComanda(int idComanda) {
			this.idComanda = idComanda;
		}
		
		public String getIdClient() {
			return idClient;
		}
		
		public void setIdClient(String idClient) {
			this.idClient = idClient;
		}
		
		public Date getDataObertura() {
			return dataObertura;
		}
		
		public void setDataObertura(Date dataObertura) {
			this.dataObertura = dataObertura;
		}
		
		public Date getDataFinalitzacio() {
			return dataFinalitzacio;
		}
		
		public void setDataFinalitzacio(Date dataFinalitzacio) {
			this.dataFinalitzacio = dataFinalitzacio;
		}
		
		public char getStatus() {
			return status;
		}
		
		public void setStatus(char status) {
			this.status = status;
		}
		
		public ArrayList<LiniaComanda> getLiniesComanda () {
			return LiniesComanda;
		}
		
		public float getPreu() {
			
		for (LiniaComanda liniesComandes : LiniesComanda) {
			preu += liniesComandes.preuLinia;
		}
			return preu;
		}
		
//metodes
		
		
		public void calcularPreu() {
			
		}
		
		public void comprovarPagament() {
			
		}
		
		public void llistatComandes(String Article) {
			
		}
		
		public void llistatComandesDia(Date date) {
			
		}
		
		public void consultaStatusLinies(String Comanda) {
			
		}
		
		public void enviaComanda(String idComanda) {
			
		}

		public String toString() {
			return "Comanda [idComanda=" + idComanda + ", idClient=" + idClient + ", preu=" + getPreu() + ", dataObertura="
					+ dataObertura + ", dataFinalitzacio=" + dataFinalitzacio + ", status=" + status + "]";
		}
		
		
		
		
		
}