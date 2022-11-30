package codigo.src;

public class FabricaCarro implements IFabricaVeiculo {
    @Override
    public Veiculo criar(String placa, double valorVenda, String combustivelInicial) {
        return new Carro(placa, valorVenda);
    }
}
