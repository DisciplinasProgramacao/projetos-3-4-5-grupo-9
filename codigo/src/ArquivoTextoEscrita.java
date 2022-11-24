package codigo.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoTextoEscrita{
	private BufferedWriter saida;
  
	ArquivoTextoEscrita(String name){
	  try{
		saida = new BufferedWriter(new FileWriter(name));
	  } catch(Exception ex) {
		System.out.println("Arquivo não encontrado");
		
	  }
	}
  
	public void closeArquivo(){
	  try{
		saida.close();
	  } catch (Exception e) {
		System.out.println("Something went wrong.");
		
	  }
	}
  
	 public void escrever(String texto){
	  try{
		saida.write(texto);
		saida.newLine();
	  } catch (Exception e) {
		System.out.println("Something went wrong.");
		
	  }
	}
  }