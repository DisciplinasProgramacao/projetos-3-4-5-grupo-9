package codigo.src;
import java.util.*;

public class App {

	static Scanner input = new Scanner(System.in);


	public static Veiculo addVeiculoFrota(int tipo, String placa, double valorVenda, double gastoLitro){
		Veiculo novoVeiculo = new Caminhao(placa, gastoLitro, valorVenda);

		switch (tipo) {
			case 1:
				novoVeiculo = new Caminhao(placa, gastoLitro, valorVenda);
			case 2:
				novoVeiculo = new Carro(placa, gastoLitro, valorVenda);
			case 3:
				novoVeiculo = new Furgao(placa, gastoLitro, valorVenda);
			case 4:
				novoVeiculo = new Van(placa, gastoLitro, valorVenda);


		}

		return novoVeiculo;
	}

	public static int menu() {

        System.out.println();

        System.out.println("Sistema de frotas");
        System.out.println("==========================");
        System.out.println("1 - Adicionar veículo");
		System.out.println("2 - Adicionar rota na frota");
        System.out.println("2 - Adicionar rota para veiculo");
        System.out.println("3 - Localizar veiculo");
		System.out.println("4 - Imprimir relatório");

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
		Rota rota1 = new Rota(300, "Rio de janeiro");
		Veiculo caminhao = new Caminhao("1234", 3, 200000);
		Veiculo carro = new Carro("4321", 2, 50000);

		Frota frota = new Frota(21312);

		int opcao;

        do {
            opcao = menu();

            switch (opcao) {
                case 1:
					int tipo;
					double valorVenda;
					double gastoLitro;
					String placa;

                    System.out.println("Digite o tipo de veículo: ");
					System.out.println("1 - Caminhao");
					System.out.println("2 - Carro");
					System.out.println("3 - Furgao");
					System.out.println("4 - Van");

					tipo = input.nextInt();
					input.nextLine();

					System.out.println("Digite a placa: ");
					placa = input.nextLine();

					System.out.println("Digite o valor de venda: ");
					valorVenda = Double.parseDouble(input.nextLine());

					System.out.println("Digite o gasto por litro: ");

					gastoLitro = Double.parseDouble(input.nextLine());

					Veiculo novoVeiculo = addVeiculoFrota(tipo, placa, valorVenda, gastoLitro);
					frota.adicionarVeiculo(novoVeiculo);
				
                    break;

                case 2:
					String destino;
					double distancia;

                    System.out.println("Digite o destino da rota: ");
                	destino = input.nextLine();

					System.out.println("Digite a distancia da rota: ");
					distancia = Double.parseDouble(input.nextLine());

					Rota novaRota = new Rota(distancia, destino);
					frota.adicionarRotaFrota(novaRota);

                    break;

                case 3:
					String placaBuscar;
					String rotaBuscar;
					Veiculo veiculoEncontrado;
					Rota rotaEncontrada;


                    System.out.println("Digite a placa do veiculo: ");
					placaBuscar = input.nextLine();
					veiculoEncontrado = frota.localizarVeiculo(placaBuscar);

					if(veiculoEncontrado == null){
						System.out.println("Veiculo nao encontrado");
						break;
					}

					System.out.println("Digite o destino da rota: ");
					rotaBuscar = input.nextLine();
					rotaEncontrada = frota.localizarRota(rotaBuscar);

					if(rotaEncontrada == null){
						System.out.println("Rota nao encontrada");
						break;
					}

					rotaEncontrada = veiculoEncontrado.incluirRota(rotaEncontrada);   

					if(rotaEncontrada == null){
						System.out.println("Veículo ja excedeu o limite diário");
						break;
					}

					System.out.println("Rota adicionada com sucesso!");

				case 4:
					String veiculoBuscar;
					Veiculo veiculoAchado;

					System.out.println("Digite a placa do veiculo: ");
					veiculoBuscar = input.nextLine();
					veiculoAchado = frota.localizarVeiculo(veiculoBuscar);

					if(veiculoAchado == null){
						System.out.println("Veiculo nao encontrado");
						break;
					}

            }




        } while (opcao != 0);
		
		carro.incluirRota(rota1);
		
		carro.getRotas().stream().forEach(x -> System.out.println(x));
		
		caminhao.getRotas().stream().forEach(x -> System.out.println(x));
	}

}
