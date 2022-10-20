package codigo.src;
import java.util.ArrayList;

public class Frota {
    private int codigo;
    private ArrayList<Rota> rotas;
    private ArrayList<Veiculo> veiculos;

    public Frota(int codigo){
        this.codigo = codigo;
        this.rotas = new ArrayList<Rota>();
        this.veiculos = new ArrayList<Veiculo>();
    }

    public void adicionarVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public void adicionarRotaFrota(Rota rota){
        this.rotas.add(rota);
    }

}