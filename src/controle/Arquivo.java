package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arquivo {
	
	File arquivo = new File("entrada.txt");
	HashMap<String, ArrayList<Instancia>> mapeiaCluster = new HashMap<String, ArrayList<Instancia>>();
	HashMap<Integer,Integer> qtEscritos = new HashMap<Integer,Integer>();
	
	public Arquivo() {
		lerArquivo();
	}
	
	private void lerArquivo() {
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			} else {

				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				while (br.ready()) {

					String linha = br.readLine();
					String[] valores = linha.split(",");
					
					Instancia inst = new Instancia(valores[1],
													valores[2],
													valores[3],
													valores[4],
													valores[5],
													valores[6],
													valores[7],
													valores[8],
													valores[9],
													valores[10],
													valores[11],
													valores[12],
													valores[13],
													valores[14],
													valores[15]);
					
					if(mapeiaCluster.get(valores[16]) == null){
						mapeiaCluster.put(valores[16], new ArrayList<Instancia>());
					}
					
					mapeiaCluster.get(valores[16]).add(inst);
					
				}

				br.close();
				fr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionaArquivo(ArrayList<Instancia> instancias, String nomeDoArquivo) throws IOException {
		
		File arquivo = new File("clusters/"+nomeDoArquivo+" qtInstancias = "+instancias.size()+".txt");
		
		if(instancias.size() <= 3){
			
			if(qtEscritos.get(instancias.size()) == null)
				qtEscritos.put(instancias.size(), 0);
			
			arquivoPoucasInstancias(nomeDoArquivo, instancias.size());
			qtEscritos.put(instancias.size(), qtEscritos.get(instancias.size())+1);
		}
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		try {
			FileWriter fw = new FileWriter(arquivo, false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Instancia i : instancias){
				bw.write(i.toString());
				bw.newLine();
			}
			
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionaConjuntos(String nome,HashMap<String, HashSet<String>> conjuntos) throws IOException {
	
		File arquivo = new File("estatisticas/"+nome+".txt");
		
		for(String s : conjuntos.keySet()){
			
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			try {
				FileWriter fw = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				if(conjuntos.get(s).size() <= 3){
					bw.write(s+" : "+conjuntos.get(s).toString());
					bw.newLine();
				}
				
				
				
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void arquivoPoucasInstancias(String nomeCluster, int qtInstancias) throws IOException {
		
		File arquivo = new File("poucasInstancias "+qtInstancias+".txt");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(nomeCluster+", ");
			
			if(qtEscritos.get(qtInstancias)%6 == 0 && qtEscritos.get(qtInstancias) != 0)
				bw.newLine();
			
			
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, ArrayList<Instancia>> getMapeiaCluster() {
		return mapeiaCluster;
	}

	public void setMapeiaCluster(HashMap<String, ArrayList<Instancia>> mapeiaCluster) {
		this.mapeiaCluster = mapeiaCluster;
	}
	
}
