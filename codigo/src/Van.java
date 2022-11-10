package codigo.src;

import java.util.ArrayList;

public class Van extends Veiculo {

	public Van(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 60.0;
		this.capacidadeMaxima = 60;
		this.valorSeguro = valorVenda * 0.03;
		this.valorIpva = valorVenda * 0.03;
		this.tipo = "Van";

		ArrayList<Combustivel> combustiveis = new ArrayList<Combustivel>();
		Combustivel gasolina = new Gasolina();
		Combustivel diesel = new Diesel();

		combustiveis.add(gasolina);
		combustiveis.add(diesel);
		combustiveis.get(0).ativar();

		this.combustivel = combustiveis;
	}

	@Override
	double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 10000) * (120 + 500)) + this.gastosTotaisAbastecimento;
	}

}
