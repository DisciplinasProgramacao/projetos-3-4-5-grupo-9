package codigo.src;
import java.util.*;

public class App {

	static Scanner input = new Scanner(System.in);

	public static int menu() {

        System.out.println();

        System.out.println("Sistema de frotas");
        System.out.println("==========================");
        System.out.println("1 - Adicionar veículo");
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
		
		carro.incluirRota(rota1);
		
		carro.getRotas().stream().forEach(x -> System.out.println(x));
		
		caminhao.getRotas().stream().forEach(x -> System.out.println(x));
	}

}
