package codigo.src;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Serializacao {

	

	
	ObjectOutputStream oos = new ObjectOutputStream("veiculo.bin"));
	oos.writeObject();

	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
	Veiculo veiculo = (Veiculo) ois.readObject();
	
	
	oos.close();
	ois.close()
}
