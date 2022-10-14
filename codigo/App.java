package codigo;

public class App {

	public static void main(String[] args) {
		Rota rota1 = new Rota(300, "Rio de janeiro");
		Veiculo caminhao = new Caminhao("1234", 3, 200000);
		Veiculo carro = new Carro("4321", 2, 50000);
		
		carro.incluirRota(rota1);
		
		carro.getRotas().stream().forEach(x -> System.out.println(x));
		
		caminhao.getRotas().stream().forEach(x -> System.out.println(x));
	}

}
