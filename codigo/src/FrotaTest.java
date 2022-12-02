package codigo.src;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

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
