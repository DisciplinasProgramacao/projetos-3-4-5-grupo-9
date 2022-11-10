package codigo.src;

import java.util.ArrayList;

public class Carro extends Veiculo {
	

	public Carro(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 50.0;
		this.capacidadeMaxima = 50;
		this.valorSeguro = (valorVenda * 0.05) + 300;
		this.valorIpva = valorVenda * 0.04;
		this.tipo = "Carro";

		ArrayList<Combustivel> combustiveis = new ArrayList<Combustivel>();
		Combustivel gasolina = new Gasolina();
		Combustivel etanol = new Etanol();
		combustiveis.add(gasolina);
		combustiveis.add(etanol);
		combustiveis.get(0).ativar();

		this.combustivel = combustiveis;
	}

	@Override
	public double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor( this.quilometragemTotal/10000) * 80) + this.gastosTotaisAbastecimento;
		
	}

}
