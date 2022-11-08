
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
	public static int menu() {
		System.out.println();
		System.out.println("Sistema de frotas");
		System.out.println("==========================");
		System.out.println("1 - Adicionar ve�culo");
		System.out.println("2 - Adicionar rota na frota");
		System.out.println("3 - Adicionar rota para veiculo");
		System.out.println("4 - Localizar veiculo");
		System.out.println("5 - Imprimir relat�rio");
		System.out.println("6 - Carregar de arquivo");

		System.out.println("0 - Sair");
		System.out.print("Digite sua op��o: ");
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
					System.out.println("Digite o tipo de ve�culo: ");
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
						System.out.println("\nVe�culo ja excedeu o limite di�rio");
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

				case 6:
					String nomeArquivo;

					System.out.println("\nDigite o nome do arquivo: ");
					nomeArquivo = input.nextLine();

					LeitorArquivo leitor = new LeitorArquivo();

					ArrayList<Veiculo> veiculosArquivo = leitor.leituraArquivo(nomeArquivo);

					for(Veiculo veiculoArr : veiculosArquivo){
						frota.adicionarVeiculo(veiculoArr);
					}

					System.out.println("Todos os ve�culos do arquivo foram adicionados a frota");
					break;


			}

		} while (opcao != 0);
		
	}
}