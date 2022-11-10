package codigo.src;

public class Combustivel {

	protected double consumo;
	protected double precoAbastecimento;
	protected double totalNoTanque;
	protected boolean ativo;
	protected String descricao;

	public Combustivel(double precoAbastecimento, double consumo, String descricao){
		this.precoAbastecimento = precoAbastecimento;
		this.consumo = consumo;
		this.descricao = descricao;
	}

	public double calcularPreco(double totalAPreencher){
        return totalAPreencher * this.precoAbastecimento;
    }

	public double consumo(){
		return this.consumo;
	}

	public boolean estaAtivo(){
		return this.ativo;
	}

	public void ativar(){
		 this.ativo = true;
	}

	public void desativar(){
		this.ativo = false;
   }

	public String descricao(){
		return this.descricao;
	}

}
