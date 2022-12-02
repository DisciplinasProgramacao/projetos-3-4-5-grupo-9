package codigo.src;

public class FabricaCarroGasolina implements IFabricaVeiculo{


    @Override
    public Veiculo criar(String placa, double valorVenda){
        Veiculo van = new Van(placa, valorVenda);
        van.combustivel.get(0).ativar();

        return van;
    }
    
    
}
