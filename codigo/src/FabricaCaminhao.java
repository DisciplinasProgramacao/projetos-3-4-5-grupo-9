package codigo.src;

public class FabricaCaminhao implements IFabricaVeiculo {
    @Override
    public Veiculo criar(String placa, double valorVenda) {
        Veiculo caminhao = new Caminhao(placa, valorVenda);

        return caminhao;
    }
}
