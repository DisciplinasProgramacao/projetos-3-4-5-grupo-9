package codigo.src;

public class FabricaCarroEtanol implements IFabricaVeiculo {
    @Override
    public Veiculo criar(String placa, double valorVenda){
        Veiculo van = new Carro(placa, valorVenda);
        van.combustivel.get(1).ativar();

        return van;
    }
}
