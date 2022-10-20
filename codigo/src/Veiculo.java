package codigo.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Veiculo {
	protected double valorIpva;
	protected double valorSeguro;
	ArrayList<Rota> rotas = new ArrayList<Rota>();
	protected double capacidadeTanque;
	private String placa;
	private double quilometragemMaxima;
	private double gastoLitro;
	private double quilometragemTotal;
	private double valorVenda;

	public Veiculo(String placa, double gastoLitro, double valorVenda) {
		this.placa = placa;
		this.gastoLitro = gastoLitro;
		this.valorVenda = valorVenda;
	}

	public Rota incluirRota(Rota rota){
		if(this.podeAdicionarRota(rota.getData(), rota.getDistancia())){
			this.rotas.add(rota);
			return rota;
		}

		return null;
	}

	abstract double calcularGasto();

	public ArrayList<Rota> getRotas() {
		return this.rotas;
	}

	public String getPlaca() {
		return this.placa;
	}

	public boolean podeAdicionarRota(LocalDate dataRota, double distanciaRota) {
		double totalDia = 0;



		for (Rota rota : this.rotas) {
			if (rota.getData().equals(dataRota)) {
				totalDia += rota.getDistancia();
			}
		}

		return (this.capacidadeTanque * this.gastoLitro) > (totalDia + distanciaRota);
	}

}
