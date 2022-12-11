package codigo.src;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Veiculo implements Serializable {
	protected String tipo;
	protected double valorIpva;
	protected double valorSeguro;
	ArrayList<Rota> rotas = new ArrayList<Rota>();
	protected double capacidadeTanque;
	private String placa;
	private double quilometragemMaxima;
	protected double quilometragemTotal;
	private double valorVenda;
	protected ArrayList<Combustivel> combustivel;
	protected double gastosTotaisAbastecimento;
	protected double capacidadeMaxima;

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

	public ArrayList<Combustivel> getCombustivel() {
		return this.combustivel;
	}

	public Veiculo(String placa, double valorVenda) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.quilometragemTotal = 0;
		this.gastosTotaisAbastecimento = 0;
	}

	/**
	 * Inclui uma nova rota no veículo
	 * 
	 * @param rota Rota a ser adicionada
	 * @return rota adicionada ou null caso não possa adicionar
	 */
	public Rota incluirRota(Rota rota) {
		if (this.podeAdicionarRota(rota.getDistancia())) {
			this.rotas.add(rota);
			this.quilometragemTotal += rota.getDistancia();
			this.capacidadeTanque -= this.getGastoComRota(rota.getDistancia());
			return rota;
		}

		return null;
	}

	/**
	 * Calcula gasto total do veículo com rotas e manutenções.
	 * 
	 * @return gasto total
	 */
	public abstract double calcularGasto();

	public ArrayList<Rota> getRotas() {
		return this.rotas;
	}

	/**
	 * Gera texto com placa, valor de venda e lista de rotas pro veículo
	 * 
	 * @return texto gerada
	 */
	public String mostrarDados() {
		String dados = "";

		dados += "\nPlaca: " + this.placa + "\n" +
				"Valor de venda: R$ " + this.valorVenda + "\n" +
				"Rotas: \n";

		for (Rota rota : this.rotas) {
			dados += "Rota para: " + rota.getDestino() + "\n" +
					"Distancia: " + rota.getDistancia() + "\n";
		}

		return dados;
	}

	/**
	 * Gera texto com gasto total do veículo
	 * 
	 * @return texto gerado
	 */
	public String gerarRelatorio() {
		String relatorio = "\nO gasto total do veículo é de R$ " + this.calcularGasto();

		return relatorio;

	}

	public String getPlaca() {
		return this.placa;
	}

	public String getArquivavel() {
		return this.placa + ";" + this.valorVenda + ";" + this.tipo;
	}

	/**
	 * Calcula quanto será gasto em consumo de combustível com a rota de acordo com
	 * a distancia
	 * 
	 * @param distanciaRota distancia da rota a ser adicionada
	 * @return gasto calculado
	 */
	public double getGastoComRota(double distanciaRota) {
		double gasto = 0;
		for (Combustivel combustivel : this.combustivel) {
			if (combustivel.estaAtivo()) {
				gasto = distanciaRota / combustivel.consumo();
			}
		}

		return Math.round(gasto * 100.0) / 100.0;

	}

	/**
	 * Informa se será possível adicionar a rota de acordo com a distância e a
	 * capacidade do tanque
	 * 
	 * @param distanciaRota distancia da rota a ser adicionada
	 * @return true (pode) ou false (não pode)
	 */
	public boolean podeAdicionarRota(double distanciaRota) {

		double capacidadeSeAdicionada = this.capacidadeTanque - this.getGastoComRota(distanciaRota);

		return capacidadeSeAdicionada > 0;
	}

	public double getGastosTotaisAbastecimento() {
		return this.gastosTotaisAbastecimento;
	}

	/**
	 * De acordo com o tipo de combustível escolhido, ativa o mesmo e enche o tanque
	 * do veículo.
	 * 
	 * @param tipoIndex index do tipo de veículo a ser adicionado
	 */
	public void abastecerTanque(int tipoIndex) {
		Combustivel combustivelAchado = this.combustivel.get(tipoIndex - 1);

		for (Combustivel combustivel : combustivel) {
			if (combustivel.estaAtivo() && !(combustivel.descricao().equals(combustivelAchado.descricao()))) {
				combustivel.desativar();
				this.gastosTotaisAbastecimento += combustivelAchado.calcularPreco(this.capacidadeTanque);
			} else {
				combustivel.ativar();
				this.gastosTotaisAbastecimento += combustivelAchado
						.calcularPreco(this.capacidadeMaxima - this.capacidadeTanque);
			}
		}

		this.capacidadeTanque = this.capacidadeMaxima;

	}

}
