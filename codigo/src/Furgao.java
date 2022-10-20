package codigo.src;

public class Furgao extends Veiculo {
	

	public Furgao(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 80.0;
		this.valorSeguro = valorVenda * 0.03;
		this.valorIpva = valorVenda * 0.03;
		this.tipo = "Furgao";
	}


	@Override
	double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 10000) * (120 + 500));
	}

}
