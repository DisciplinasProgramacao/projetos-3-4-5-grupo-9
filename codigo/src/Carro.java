package codigo.src;

public class Carro extends Veiculo {
	
	public Carro(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 50.0;
		this.valorSeguro = (valorVenda * 0.05) + 300;
		this.valorIpva = valorVenda * 0.04;
	}


	@Override
	double calcularGasto() {
		return 0;
	}

}
