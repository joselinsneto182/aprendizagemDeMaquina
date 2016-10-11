package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		
		HashMap<String, ArrayList<Instancia>> mapeiaCluster = new HashMap<String, ArrayList<Instancia>>();
		
		Arquivo arq = new Arquivo();
		
		Estatisticas est;
		
		mapeiaCluster = arq.getMapeiaCluster();
		
		for(String s : mapeiaCluster.keySet()){
			arq.adicionaArquivo(mapeiaCluster.get(s), s);
		}
		
		est = new Estatisticas(mapeiaCluster, arq);
		
		est.conjuntosDeValores();

	}

}
