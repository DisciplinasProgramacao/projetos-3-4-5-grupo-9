package codigo.src;

public class Caminhao extends Veiculo {
	
	public Caminhao(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 250.0;
		this.valorSeguro = (valorVenda * 0.02) + 2000;
		this.valorIpva = valorVenda * 0.01;
	}

	@Override
	void incluirRota(Rota rota) {
		this.rotas.add(rota);
		
	}

	@Override
	double calcularGasto() {
		// TODO Auto-generated method stub
		return 0;
	}

}
