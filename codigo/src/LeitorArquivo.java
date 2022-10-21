package codigo.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {

	public ArrayList<Veiculo> leituraArquivo(String nome) {
		File file = new File(nome);
		Scanner sc = null;
		ArrayList<Veiculo> listVeiculos = new ArrayList<Veiculo>();
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String linha[] = sc.nextLine().split(";");

				Veiculo veiculo;

				veiculo = new Caminhao(linha[0], Double.parseDouble(linha[2]),
						Double.parseDouble(linha[1]));

				if (linha[3].equals("CARRO")) {

					veiculo = new Carro(linha[0], Double.parseDouble(linha[2]), Double.parseDouble(linha[1]));

				}

				if (linha[3].equals("FURGAO")) {

					veiculo = new Furgao(linha[0], Double.parseDouble(linha[2]), Double.parseDouble(linha[1]));

				}

				if (linha[3].equals("VAN")) {

					veiculo = new Van(linha[0], Double.parseDouble(linha[2]), Double.parseDouble(linha[1]));

				}

				listVeiculos.add(veiculo);
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
