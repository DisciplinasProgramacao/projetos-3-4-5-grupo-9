package codigo;

public class Van extends Veiculo {

	public Van(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 60.0;
		this.valorSeguro = valorVenda * 0.03;
		this.valorIpva = valorVenda * 0.03;
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
