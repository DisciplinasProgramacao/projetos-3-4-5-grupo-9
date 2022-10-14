package codigo;

import java.time.LocalDateTime;

public class Rota {
	
	private LocalDateTime data;
	private double distancia;
	private String destino;
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
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
	
	public Rota(double distancia, String destino) {
		this.data = LocalDateTime.now();
		this.distancia = distancia;
		this.destino = destino;
	}
	
	
	
	
}
