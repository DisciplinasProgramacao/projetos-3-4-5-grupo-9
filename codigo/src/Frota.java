package codigo.src;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Frota {
    private int codigo;
    private ArrayList<Rota> rotas;
    private ArrayList<Veiculo> veiculos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(ArrayList<Rota> rotas) {
        this.rotas = rotas;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Frota(int codigo) {
        this.codigo = codigo;
        this.rotas = new ArrayList<Rota>();
        this.veiculos = new ArrayList<Veiculo>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void adicionarRotaFrota(Rota rota) {
        this.rotas.add(rota);
    }

    public Veiculo localizarVeiculo(String placa) {
        for (Veiculo veiculo : this.veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }

        return null;
    }

    public Rota localizarRota(String destino) {
        for (Rota rota : this.rotas) {
            if (rota.getDestino().equals(destino)) {
                return rota;
            }
        }

        return null;
    }

    public double quilometragemMedia() {
        double distanciaTotal = 0;

        for (Rota rota : this.rotas) {
            distanciaTotal += rota.getDistancia();

        }

        if (distanciaTotal != 0) {
            return distanciaTotal / this.rotas.size();
        }

        return 0;
    }

    public ArrayList<Veiculo> top3VeiculosComMaisRotas() {
        ArrayList<Veiculo> topVeiculos = new ArrayList<Veiculo>();

        for (Veiculo veiculo : this.veiculos)
            topVeiculos.add(veiculo);

        Collections.sort(topVeiculos,
                (o1, o2) -> Integer.compare(o1.getRotas().size(), o2.getRotas().size()));

        Collections.reverse(topVeiculos);

        return topVeiculos;
    }

    public ArrayList<Veiculo> veiculosOrdenadosPorGasto() {
        ArrayList<Veiculo> novoArray = new ArrayList<Veiculo>();

        for (Veiculo veiculo : this.veiculos)
            novoArray.add(veiculo);

        Collections.sort(novoArray,
                (o1, o2) -> Double.compare(o1.calcularGasto(), o2.calcularGasto()));

        Collections.reverse(novoArray);
        return novoArray;
    }

    public ArrayList<Rota> buscarRotaPorData(String data) throws Exception {
        ArrayList<Rota> rotasEncontradas = new ArrayList<Rota>();

        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataDeBusca = LocalDate.parse(data, formatador);
            for (Rota rota : this.rotas) {
                if (rota.getData().equals(dataDeBusca)) {
                    rotasEncontradas.add(rota);
                }
    
            }
    
            return rotasEncontradas;
        } catch (Exception e){
            throw new Exception();
        }
      

        

    }

}