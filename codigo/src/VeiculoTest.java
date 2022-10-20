package codigo.src;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class VeiculoTest {

    @Test
    public void testeIncluirRota(){
        Veiculo novoVeiculo = new Caminhao("123AB", 3, 50000);
        Rota novaRota = new Rota(300, "teste");

        novoVeiculo.incluirRota(novaRota);
        
        assertEquals(novoVeiculo.getRotas().get(0).getDestino() , "teste");
    }

    @Test
    public void testeNaoIncluirRota(){
        Veiculo novoVeiculo = new Caminhao("123AB", 3, 50000);
        
        Rota rota1 = new Rota(300, "teste");
        Rota rota2 = new Rota(300, "teste1");
        Rota rota3 = new Rota(300, "teste2"); // nao pode ser adicionada

        novoVeiculo.incluirRota(rota1);
        novoVeiculo.incluirRota(rota2);
        novoVeiculo.incluirRota(rota3);

        
        assertEquals(novoVeiculo.getRotas().size() , 2);
    }

    
}
