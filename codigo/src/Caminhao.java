package codigo.src;

public class Caminhao extends Veiculo {
	
	public Caminhao(String placa, double gastoLitro, double valorVenda) {
		super(placa, gastoLitro, valorVenda);
		this.capacidadeTanque = 250.0;
		this.valorSeguro = (valorVenda * 0.02) + 2000;
		this.valorIpva = valorVenda * 0.01;
	}


	@Override
	double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 20000) * 1000) +  (Math.floor(this.quilometragemTotal / 30000) * 1000);
		
	}

}
