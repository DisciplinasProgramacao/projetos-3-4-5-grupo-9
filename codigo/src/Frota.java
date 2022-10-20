package codigo.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Rota {

	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private LocalDate data;
	private double distancia;
	private String destino;
	
	

	public Rota(double distancia, String destino) {
		this.data = LocalDate.now();
		this.distancia = distancia;
		this.destino = destino;
	}
	
	public LocalDate getData() {
		return data;
	}

	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	

	
	
	
	
}
