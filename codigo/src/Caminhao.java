package codigo.src;

public class Caminhao extends Veiculo {
	
	
	public Caminhao(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 250.0;
		this.valorSeguro = (valorVenda * 0.02) + 2000;
		this.valorIpva = valorVenda * 0.01;
		this.tipo = "Caminhao";
	}


	@Override
	double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor(this.quilometragemTotal / 20000) * 1000) +  (Math.floor(this.quilometragemTotal / 30000) * 1000);
		
	}

}
