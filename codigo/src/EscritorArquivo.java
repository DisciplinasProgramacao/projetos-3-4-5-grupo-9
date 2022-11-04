package codigo.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorArquivo {

	public static void escritaArquivo(String path, Veiculo veiculo) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

			bw.write(veiculo.getPlaca()+";"+ veiculo.getValorVenda()+";"+veiculo.getGastoLitro()+";"+veiculo.getTipo());
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
