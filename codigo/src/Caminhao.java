package codigo.src;

import java.util.ArrayList;

public class Caminhao extends Veiculo {
	
	
	public Caminhao(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 250.0;
		this.capacidadeMaxima = 250;
		this.valorSeguro = (valorVenda * 0.02) + 2000;
		this.valorIpva = valorVenda * 0.01;
		this.tipo = "Caminhao";

		ArrayList<Combustivel> combustiveis = new ArrayList<Combustivel>();
		Combustivel diesel = new Diesel();
		combustiveis.add(diesel);
		combustiveis.get(0).ativar();

		this.combustivel = combustiveis;
	}


	@Override
	public double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 20000) * 1000) +  (Math.floor(this.quilometragemTotal / 30000) * 1000) + this.gastosTotaisAbastecimento;
		
	}

}
