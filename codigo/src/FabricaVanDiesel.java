package codigo.src;

public class FabricaVanDiesel implements IFabricaVeiculo{
    @Override
    public Veiculo criar(String placa, double valorVenda){
        Veiculo van = new Van(placa, valorVenda);
        van.combustivel.get(1).ativar();

        return van;
    }
}
