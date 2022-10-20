package codigo.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Veiculo {
	protected String tipo;
	protected double valorIpva;
	protected double valorSeguro;
	ArrayList<Rota> rotas = new ArrayList<Rota>();
	protected double capacidadeTanque;
	private String placa;
	private double quilometragemMaxima;
	private double gastoLitro;
	protected double quilometragemTotal;
	private double valorVenda;
	
	

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorIpva() {
		return valorIpva;
	}

	public void setValorIpva(double valorIpva) {
		this.valorIpva = valorIpva;
	}

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(double capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public double getQuilometragemMaxima() {
		return quilometragemMaxima;
	}

	public void setQuilometragemMaxima(double quilometragemMaxima) {
		this.quilometragemMaxima = quilometragemMaxima;
	}

	public double getGastoLitro() {
		return gastoLitro;
	}

	public void setGastoLitro(double gastoLitro) {
		this.gastoLitro = gastoLitro;
	}

	public double getQuilometragemTotal() {
		return quilometragemTotal;
	}

	public void setQuilometragemTotal(double quilometragemTotal) {
		this.quilometragemTotal = quilometragemTotal;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void setRotas(ArrayList<Rota> rotas) {
		this.rotas = rotas;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Veiculo(String placa, double gastoLitro, double valorVenda) {
		this.placa = placa;
		this.gastoLitro = gastoLitro;
		this.valorVenda = valorVenda;
		this.quilometragemTotal = 0;
	}

	public Rota incluirRota(Rota rota) {
		if (this.podeAdicionarRota(rota.getData(), rota.getDistancia())) {
			this.rotas.add(rota);
			this.quilometragemTotal += rota.getDistancia();
			return rota;
		}

		return null;
	}

	abstract double calcularGasto();

	public ArrayList<Rota> getRotas() {
		return this.rotas;
	}

	public String mostrarDados() {
		String dados = "";

		dados += "\nPlaca: " + this.placa + "\n" +
				"Valor de venda: R$ " + this.valorVenda + "\n" +
				"Km por litro: " + this.gastoLitro + "\n" +
				"Rotas: \n";

		for (Rota rota : this.rotas) {
			dados += "Rota para: " + rota.getDestino() + "\n" +
					"Distancia: " + rota.getDistancia() + "\n";
		}

		return dados;
	}

	public String gerarRelatorio(){
		String relatorio = "\nO gasto total do veículo é de R$ " + this.calcularGasto();

		return relatorio;

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
