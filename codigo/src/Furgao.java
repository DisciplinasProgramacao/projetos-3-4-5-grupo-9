package codigo.src;

import java.util.ArrayList;

public class Furgao extends Veiculo {
	

	public Furgao(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 80.0;
		this.capacidadeMaxima = 80;
		this.valorSeguro = valorVenda * 0.03;
		this.valorIpva = valorVenda * 0.03;
		this.tipo = "Furgao";

		ArrayList<Combustivel> combustiveis = new ArrayList<Combustivel>();
		Combustivel gasolina = new Gasolina();
		combustiveis.add(gasolina);
		combustiveis.get(0).ativar();

		this.combustivel = combustiveis;
	}


	@Override
	public double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 10000) * (120 + 500)) + this.gastosTotaisAbastecimento;
	}

}
