package codigo.src;

public class Carro extends Veiculo {
	

	public Carro(String placa, double valorVenda) {
		super(placa, valorVenda);
		this.capacidadeTanque = 50.0;
		this.valorSeguro = (valorVenda * 0.05) + 300;
		this.valorIpva = valorVenda * 0.04;
		this.tipo = "Carro";
	}

	@Override
	double calcularGasto() {
		return this.valorSeguro + this.valorIpva + (Math.floor( this.quilometragemTotal/10000) * 80);
		
	}

}
