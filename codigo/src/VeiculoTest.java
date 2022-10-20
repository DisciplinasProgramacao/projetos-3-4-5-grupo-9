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

    @Test
    public void testeGastoVeiculo(){
        Veiculo caminhao = new Caminhao("123AB", 3, 50000);      
        assertEquals(caminhao.calcularGasto() , 3500);

        Veiculo van = new Van("123AC", 3, 50000);
        assertEquals(van.calcularGasto() , 3000);

        Veiculo furgao = new Furgao("123AD", 3, 50000);
        assertEquals(furgao.calcularGasto() , 3000);

        Veiculo carro = new Carro("123AE", 3, 50000);
        assertEquals(carro.calcularGasto() , 3000);
    }

    
}
