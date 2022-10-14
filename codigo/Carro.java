package codigo;

public class Carro extends Veiculo {
	
	public Carro(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 50.0;
		this.valorSeguro = (valorVenda * 0.05) + 300;
		this.valorIpva = valorVenda * 0.04;
	}

	@Override
	void incluirRota(Rota rota) {
		this.rotas.add(rota);
	}

	@Override
	double calcularGasto() {
		return 0;
	}

}
