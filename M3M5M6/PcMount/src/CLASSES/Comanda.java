package CLASSES;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Comanda {

//atributs

	String idComanda;
	String idClient;
	float preu;
	String dataObertura;
	String dataFinalitzacio;
	String status;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	ArrayList<LiniaComanda> LiniesComanda = new ArrayList<LiniaComanda>();

//contructor

	public Comanda(String idClient, String idComanda, String status, String dataFinalitzacio) {
		
		this.idClient = idClient;
		this.idComanda = idComanda;
		this.dataObertura = sdf.format(new Date());
		this.preu = 0;
		this.dataFinalitzacio = dataFinalitzacio;
		this.status = status;
		

	}
	
	
	//constructor 2
	public Comanda(String idClient, String status, ArrayList<LiniaComanda> liniesComanda, String dataFinalitzacio) {
		
		this.idClient = idClient;
		//this.idComanda = idComanda;
		this.dataObertura = sdf.format(new Date());
		this.dataFinalitzacio = dataFinalitzacio;
		this.status = status;
		this.LiniesComanda = liniesComanda;

	}
	
	//contructor 3
	
	public Comanda(String idComanda) {
		this.idComanda = idComanda;
	}
	

//metodes getters i setters

	public String getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(String idComanda) {
		this.idComanda = idComanda;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getDataObertura() {
		return dataObertura;
	}

	public void setDataObertura(String dataObertura) {
		this.dataObertura = dataObertura;
	}

	public String getDataFinalitzacio() {
		return dataFinalitzacio;
	}

	public void setDataFinalitzacio(String dataFinalitzacio) {
		this.dataFinalitzacio = dataFinalitzacio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<LiniaComanda> getLiniesComanda() {
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

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", idClient=" + idClient + ", preu=" + getPreu() + ", dataObertura="
				+ dataObertura + ", dataFinalitzacio=" + dataFinalitzacio + ", status=" + status + ", LiniesComanda="
				+ LiniesComanda + "]\n\n";
	}

}