
package codigo.src;

import java.util.*;

public class App {
	static Scanner input = new Scanner(System.in);

	public static Veiculo addVeiculoFrota(int tipo, String placa, double valorVenda) {

		Veiculo novoVeiculo = new Caminhao(placa, valorVenda);

		switch (tipo) {
			case 1:

				novoVeiculo = new Caminhao(placa, valorVenda);
				break;
			case 2:

				novoVeiculo = new Carro(placa, valorVenda);
				break;
			case 3:

				novoVeiculo = new Furgao(placa, valorVenda);
				break;
			case 4:

				novoVeiculo = new Van(placa, valorVenda);
				break;
		}
		return novoVeiculo;
	}

	public static int menuTipoCombustivel(ArrayList<Combustivel> combustiveis) {
		System.out.println("Escolha o tipo de combustivel");
		for (int i = 0; i < combustiveis.size(); i++) {
			System.out.println("\n" + (i + 1) + " - " + combustiveis.get(i).descricao());
		}

		int resposta = input.nextInt();
		input.nextLine();
		return resposta;
	}

	public static int menu() {
		System.out.println();
		System.out.println("Sistema de frotas");
		System.out.println("==========================");
		System.out.println("1 - Adicionar veiculo");
		System.out.println("2 - Adicionar rota na frota");
		System.out.println("3 - Adicionar rota para veiculo");
		System.out.println("4 - Localizar veiculo");
		System.out.println("5 - Imprimir relatorio");
		System.out.println("6 - Carregar de arquivo");
		System.out.println("7 - Visualizar quilometragem media da frota");
		System.out.println("8 - Listar veiculos decrescentemente por gasto");
		System.out.println("9 - Buscar rota por data");
		System.out.println("10 - Listar top3 veiculos com mais rotas");

		System.out.println("0 - Sair");
		System.out.print("Digite sua opção: ");
		try {
			int opcao = input.nextInt();
			input.nextLine();
			return opcao;
		} catch (InputMismatchException ie) {
			return -1;
		}
	}

	public static void main(String[] args) {

		Frota frota = new Frota(21312);

		int opcao;

		do {
			opcao = menu();
			switch (opcao) {
				case 1:
					int tipo;
					double valorVenda;
					String placa;
					System.out.println("Digite o tipo de veiculo: ");
					System.out.println("1 - Caminhao");
					System.out.println("2 - Carro");
					System.out.println("3 - Furgao");
					System.out.println("4 - Van");
					tipo = input.nextInt();
					input.nextLine();
					System.out.println("\nDigite a placa: ");
					placa = input.nextLine();
					System.out.println("\nDigite o valor de venda: ");
					valorVenda = Double.parseDouble(input.nextLine());
					Veiculo novoVeiculo = addVeiculoFrota(tipo, placa, valorVenda);
					frota.adicionarVeiculo(novoVeiculo);
					break;
				case 2:
					String destino;
					double distancia;
					System.out.println("\nDigite o destino da rota: ");
					destino = input.nextLine();
					System.out.println("\nDigite a distancia da rota: ");
					distancia = Double.parseDouble(input.nextLine());
					Rota novaRota = new Rota(distancia, destino);
					frota.adicionarRotaFrota(novaRota);
					System.out.println("\nRota adicionada com sucesso!");
					break;
				case 3:
					String placaBuscar;
					String rotaBuscar;
					Veiculo veiculoEncontrado;
					Rota rotaEncontrada;
					System.out.println("\nDigite a placa do veiculo: ");
					placaBuscar = input.nextLine();
					veiculoEncontrado = frota.localizarVeiculo(placaBuscar);
					if (veiculoEncontrado == null) {
						System.out.println("\nVeiculo nao encontrado");
						break;
					}
					System.out.println("\nDigite o destino da rota: ");
					rotaBuscar = input.nextLine();
					rotaEncontrada = frota.localizarRota(rotaBuscar);
					if (rotaEncontrada == null) {
						System.out.println("\nRota nao encontrada");
						break;
					}
					rotaEncontrada = veiculoEncontrado.incluirRota(rotaEncontrada);
					if (rotaEncontrada == null) {
						System.out.println("\nVeiculo sem combustivel suficiente, deseja abastecer?");
						System.out.println("\n0 - Nao");
						System.out.println("\n1 - Sim");
						int resp = input.nextInt();
						input.nextLine();

						if (resp == 1) {
							int tipoCombustivel = menuTipoCombustivel(veiculoEncontrado.getCombustivel());
							veiculoEncontrado.abastecerTanque(tipoCombustivel);
						}

						break;
					}
					System.out.println("\nRota adicionada ao ve�culo com sucesso!");
					break;
				case 4:
					String veiculoBuscar;
					Veiculo veiculoAchado;
					System.out.println("\nDigite a placa do veiculo: ");
					veiculoBuscar = input.nextLine();
					veiculoAchado = frota.localizarVeiculo(veiculoBuscar);
					if (veiculoAchado == null) {
						System.out.println("\nVeiculo nao encontrado");
						break;
					}
					System.out.println(veiculoAchado.mostrarDados());
					break;

				case 5:
					String veiculoBuscar2;
					Veiculo veiculoAchado2;
					System.out.println("\nDigite a placa do veiculo: ");
					veiculoBuscar2 = input.nextLine();
					veiculoAchado2 = frota.localizarVeiculo(veiculoBuscar2);
					if (veiculoAchado2 == null) {
						System.out.println("\nVeiculo nao encontrado");
						break;
					}

					System.out.println(veiculoAchado2.gerarRelatorio());
					break;

				case 6:
					String nomeArquivo;

					System.out.println("\nDigite o nome do arquivo: ");
					nomeArquivo = input.nextLine();

					LeitorArquivo leitor = new LeitorArquivo();

					ArrayList<Veiculo> veiculosArquivo = leitor.leituraArquivo(nomeArquivo);

					for (Veiculo veiculoArr : veiculosArquivo) {
						frota.adicionarVeiculo(veiculoArr);
					}

					System.out.println("Todos os ve�culos do arquivo foram adicionados a frota");
					break;
				case 7:
					System.out.println("A quilometragem media da frota é " + frota.quilometragemMedia() + "km");
					break;
				case 8:
					System.out.println("\n");
					for (Veiculo veiculo : frota.veiculosOrdenadosPorGasto()) {
						System.out.println(veiculo.getPlaca() + " - R$" + veiculo.calcularGasto());

					}

					break;
				case 9:
					String dataBusca;
					System.out.println("\nDigite a data no formato (DD/MM/AAAA)");
					dataBusca = input.nextLine();
					System.out.println("\n");
					ArrayList<Rota> rotasEncontradas = frota.buscarRotaPorData(dataBusca);

					if (rotasEncontradas.size() != 0) {
						for (Rota rota : rotasEncontradas) {
							System.out.println("Destino " + rota.getDestino() + " - " + rota.getDistancia() + "km");

						}
					} else {
						System.out.println("Nenhuma rota foi encontrada para essa data!");
					}

					break;

				case 10:
					System.out.println("\n");
					for (int i = 0; i < frota.top3VeiculosComMaisRotas().size(); i++) {

						System.out.println("Top " + (i + 1) + " - " + frota.top3VeiculosComMaisRotas().get(i).getPlaca() + " - "
								+ frota.top3VeiculosComMaisRotas().get(i).getRotas().size() + " rotas");
						if (i == 2)
							break;
					}
					break;

			}

		} while (opcao != 0);

	}
}