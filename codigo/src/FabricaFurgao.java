package codigo.src;

public class FabricaFurgao implements IFabricaVeiculo{
    @Override
    public Veiculo criar(String placa, double valorVenda){
        Veiculo furgao = new Furgao(placa, valorVenda);

        return furgao;
    }
    
}
