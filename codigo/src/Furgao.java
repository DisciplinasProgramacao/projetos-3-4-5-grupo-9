package codigo.src;

public class Furgao extends Veiculo {

	public Furgao(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 80.0;
		this.valorSeguro = valorVenda * 0.03;
		this.valorIpva = valorVenda * 0.03;
	}


	@Override
	double calcularGasto() {
		// TODO Auto-generated method stub
		return 0;
	}

}
