package codigo.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import codigo.src.Caminhao;
import codigo.src.Frota;
import codigo.src.Rota;
import codigo.src.Veiculo;

public class FrotaTest {

    @Test
    public void testeFrotaEntidades(){
        Frota frota = new Frota(12335);

        Veiculo novoVeiculo = new Caminhao("123AB", 50000);
        Rota novaRota = new Rota(300, "teste");

        frota.adicionarRotaFrota(novaRota);
        frota.adicionarVeiculo(novoVeiculo);
        
        assertEquals(frota.localizarVeiculo("123AB"), novoVeiculo);
        assertEquals(frota.localizarRota("teste"), novaRota);
    }
    
}
