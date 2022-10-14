package codigo;

import java.util.ArrayList;

public abstract class Veiculo {
	protected double valorIpva;
	protected double valorSeguro;
	ArrayList<Rota> rotas = new ArrayList();
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

	abstract void incluirRota (Rota rota);
	
	abstract double calcularGasto();
	
	public ArrayList<Rota> getRotas(){
		return this.rotas;
	}


}
