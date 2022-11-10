package codigo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import codigo.src.Caminhao;
import codigo.src.Frota;
import codigo.src.Rota;
import codigo.src.Veiculo;

public class FrotaTest {

    @Test
    public void testeFrotaEntidades() {
        Frota frota = new Frota(12335);

        Veiculo novoVeiculo = new Caminhao("123AB", 50000);
        Rota novaRota = new Rota(300, "teste");

        frota.adicionarRotaFrota(novaRota);
        frota.adicionarVeiculo(novoVeiculo);

        assertEquals(frota.localizarVeiculo("123AB"), novoVeiculo);
        assertEquals(frota.localizarRota("teste"), novaRota);
    }

    @Test
    public void testeTop3MaisRotas() {
        Frota frota = new Frota(12335);

        Veiculo novoVeiculo = new Caminhao("123AB", 50000);
        Veiculo novoVeiculo2 = new Caminhao("123AC", 50000);
        Veiculo novoVeiculo3 = new Caminhao("123AD", 50000);

        Rota novaRota = new Rota(300, "teste");
        Rota novaRota2 = new Rota(300, "teste1");
        Rota novaRota3 = new Rota(300, "teste2");
        Rota novaRota4 = new Rota(300, "teste3");
        Rota novaRota5 = new Rota(300, "teste4");

        novoVeiculo.incluirRota(novaRota);
        novoVeiculo.incluirRota(novaRota2);
        novoVeiculo.incluirRota(novaRota3);

        novoVeiculo2.incluirRota(novaRota);
        novoVeiculo2.incluirRota(novaRota2);
        novoVeiculo2.incluirRota(novaRota3);
        novoVeiculo2.incluirRota(novaRota4);
        novoVeiculo2.incluirRota(novaRota5);

        novoVeiculo3.incluirRota(novaRota3);

        frota.adicionarVeiculo(novoVeiculo);
        frota.adicionarVeiculo(novoVeiculo3);
        frota.adicionarVeiculo(novoVeiculo2);

        ArrayList<Veiculo> ordenado = new ArrayList<Veiculo>();
        ordenado.add(novoVeiculo2);
        ordenado.add(novoVeiculo);
        ordenado.add(novoVeiculo3);

        assertEquals(frota.top3VeiculosComMaisRotas(), ordenado);

    }

}
