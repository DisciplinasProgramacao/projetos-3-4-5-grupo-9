
package codigo.src;

import java.util.*;

public class App {
	static Scanner input = new Scanner(System.in);

	static FabricaCaminhao caminhao = new FabricaCaminhao();
	static FabricaFurgao furgao = new FabricaFurgao();
	static FabricaCarroEtanol carroEtanol = new FabricaCarroEtanol();
	static FabricaCarroGasolina carroGasolina = new FabricaCarroGasolina();
	static FabricaVanDiesel vanDiesel = new FabricaVanDiesel();
	static FabricaVanGasolina vanGasolina = new FabricaVanGasolina();

	public static Veiculo addVeiculoFrota(int tipo, String placa, double valorVenda) {

		Veiculo novoVeiculo;

		switch (tipo) {
			case 1:
				novoVeiculo = caminhao.criar(placa, valorVenda);
				break;
			case 2:
				System.out.println("Deseja cadastrar o carro utilizando inicialmente Gasolina(1) ou Etanol(2)?");

				try {
					int tipoCombustivel = input.nextInt();
					input.nextLine();
					if (tipoCombustivel == 1) {
						novoVeiculo = carroGasolina.criar(placa, valorVenda);
					} else if (tipoCombustivel == 2) {
						novoVeiculo = carroEtanol.criar(placa, valorVenda);
					} else {
						System.out.println("Tipo de combustível inválido. Operação cancelada.");
						return null;
					}
				} catch (InputMismatchException ie) {
					input.nextLine();
					return null;
				}

				break;
			case 3:
				novoVeiculo = furgao.criar(placa, valorVenda);
				break;
			case 4:

			System.out.println("Deseja cadastrar a van utilizando inicialmente Gasolina(1) ou Diesel(2)?");

			try {
				int tipoCombustivel = input.nextInt();
				input.nextLine();
				if (tipoCombustivel == 1) {
					novoVeiculo = vanGasolina.criar(placa, valorVenda);
				} else if (tipoCombustivel == 2) {
					novoVeiculo = vanDiesel.criar(placa, valorVenda);
				} else {
					System.out.println("Tipo de combustível inválido. Operação cancelada.");
					return null;
				}
			} catch (InputMismatchException ie) {
				input.nextLine();
				return null;
			}
				break;
			default:
				System.out.println("Tipo de veículo inválido");
				return null;
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
		System.out.println("11 - Escrever no arquivo");

		System.out.println("0 - Sair");
		System.out.print("Digite sua opção: ");
		try {
			int opcao = input.nextInt();
			input.nextLine();
			return opcao;
		} catch (InputMismatchException ie) {
			input.nextLine();
			return -1;
		}
	}

	public static void main(String[] args) {

		Frota frota = new Frota(21312);

		int opcao;

		do {
			opcao = menu();
			switch (opcao) {
				case -1:
					System.out.println("Por favor, insira um numero");
					break;
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
					if (novoVeiculo != null) {
						frota.adicionarVeiculo(novoVeiculo);
					} else {
						System.out.println("Erro ao adicionar veiculo");
					}
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

					ArquivoTextoLeitura leitor = new ArquivoTextoLeitura(nomeArquivo);

					ArrayList<Veiculo> veiculosArquivo = new ArrayList<Veiculo>();

					String linha = leitor.ler();

					while (linha != null) {

						String[] dados = linha.split(";");

						Veiculo veiculoEnt = new Caminhao(dados[0], Double.parseDouble(dados[1]));

						if (dados[2].equals("CAMINHAO")) {
							veiculoEnt = new Caminhao(dados[0], Double.parseDouble(dados[1]));
						}

						if (dados[2].equals("FURGAO")) {
							veiculoEnt = new Furgao(dados[0], Double.parseDouble(dados[1]));
						}

						if (dados[2].equals("CARRO")) {
							veiculoEnt = new Carro(dados[0], Double.parseDouble(dados[1]));
						}

						if (dados[2].equals("VAN")) {
							veiculoEnt = new Van(dados[0], Double.parseDouble(dados[1]));
						}

						veiculosArquivo.add(veiculoEnt);

						linha = leitor.ler();

					}

					leitor.fecharArquivo();

					for (Veiculo veiculoArr : veiculosArquivo) {
						frota.adicionarVeiculo(veiculoArr);
					}

					System.out.println("Todos os veiculos do arquivo foram adicionados a frota");
					break;
				case 7:
					System.out.println("A quilometragem media da frota é " + frota.quilometragemMedia() + "km");
					break;
				case 8:
					System.out.println("\n");
					for (Veiculo veiculo : frota.veiculosOrdenadosPorGasto()) {
						System.out.println(veiculo.getPlaca() + " - " + veiculo.getTipo() + " - R$" + veiculo.calcularGasto());

					}

					break;
				case 9:
					String dataBusca;
					System.out.println("\nDigite a data no formato (DD/MM/AAAA)");
					dataBusca = input.nextLine();
					System.out.println("\n");
					try {
						ArrayList<Rota> rotasEncontradas = frota.buscarRotaPorData(dataBusca);
						if (rotasEncontradas.size() != 0) {
							for (Rota rota : rotasEncontradas) {
								System.out.println("Destino " + rota.getDestino() + " - " + rota.getDistancia() + "km");

							}
						} else {
							System.out.println("Nenhuma rota foi encontrada para essa data!");
						}
					} catch (Exception e) {
						System.out.println("Data inserida inválida");

					}

					break;

				case 10:
					System.out.println("\n");
					for (int i = 0; i < frota.top3VeiculosComMaisRotas().size(); i++) {

						System.out.println(
								"Top " + (i + 1) + " - " + frota.top3VeiculosComMaisRotas().get(i).getPlaca() + " - "
										+ frota.top3VeiculosComMaisRotas().get(i).getRotas().size() + " rotas");
						if (i == 2)
							break;
					}
					break;
				case 11:
					System.out.println();
					System.out.println("\nDigite o nome do arquivo: ");
					String nomeArquivoEscrita = input.nextLine();

					ArquivoTextoEscrita escritor = new ArquivoTextoEscrita(nomeArquivoEscrita);

					for (Veiculo veiculo : frota.getVeiculos()) {
						escritor.escrever(veiculo.getArquivavel());
					}

					System.out.println("Veiculos da frota adicionados ao arquivo VEICULOSESCRITA.txt");

					escritor.closeArquivo();
					break;

			}

		} while (opcao != 0);

	}
}