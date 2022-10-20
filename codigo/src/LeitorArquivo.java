package codigo.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {

	public static List<Veiculo> leituraArquivo() {
		File file = new File("src\\VEICULOS.txt");
		Scanner sc = null;
		List<Veiculo> listVeiculos = new ArrayList<>();
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String linha[] = sc.nextLine().split(";");
				
				if (linha[4] == "CAMINHAO") {

					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(linha[1]);
					veiculo.setValorVenda(Double.parseDouble(linha[2]));
					veiculo.setGastoLitro(Double.parseDouble(linha[3]));
                    veiculo.setTipo(linha[4]);
					
				}

				if (linha[4] == "CARRO") {

					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(linha[1]);
					veiculo.setValorVenda(Double.parseDouble(linha[2]));
					veiculo.setGastoLitro(Double.parseDouble(linha[3]));
                    veiculo.setTipo(linha[4]);
					
				}
				
				if (linha[4] == "FURGAO") {

					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(linha[1]);
					veiculo.setValorVenda(Double.parseDouble(linha[2]));
					veiculo.setGastoLitro(Double.parseDouble(linha[3]));
					veiculo.setTipo(linha[4]);
					
				}
				
				else {
					
					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(linha[1]);
					veiculo.setValorVenda(Double.parseDouble(linha[2]));
					veiculo.setGastoLitro(Double.parseDouble(linha[3]));
					veiculo.setTipo(linha[4]);
					
				}
				
				
				listVeiculos.add(Veiculo());
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Erro ao abrir o arquivo: " + ex.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
			System.out.println("Arquivo foi fechado!");
		}

		return listVeiculos;
	}

}
