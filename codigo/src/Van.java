package codigo.src;

public class Van extends Veiculo {

	public Van(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 60.0;
		this.valorSeguro = valorVenda * 0.03;
		this.valorIpva = valorVenda * 0.03;
		this.tipo = "Van";
	}


	@Override
	double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 10000) * (120 + 500));
	}

}
