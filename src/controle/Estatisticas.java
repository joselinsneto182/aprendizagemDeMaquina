package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Estatisticas {
	
	HashMap<String, ArrayList<Instancia>> mapeiaCluster = new HashMap<String, ArrayList<Instancia>>();
	
	HashMap<String, HashSet<String>> conjuntos;
	
	Arquivo arq;
	
	public Estatisticas(HashMap<String, ArrayList<Instancia>> mapeiaCluster, Arquivo arq) {
		this.mapeiaCluster = mapeiaCluster;
		this.arq = arq;
	}
	
	public void conjuntosDeValores() throws IOException{
		
		for(String s : mapeiaCluster.keySet()){
			
			conjuntos = new HashMap<String, HashSet<String>>();
			
			for(Instancia i : mapeiaCluster.get(s)){
				for(int contador = 0 ; contador < 15 ; contador++){
					if(conjuntos.get(nomeDoAtributo(contador)) == null){
						conjuntos.put(nomeDoAtributo(contador), new HashSet<String>());
					}
					
					conjuntos.get(nomeDoAtributo(contador)).add(i.getAtributo(contador));
				}
			}
			arq.adicionaConjuntos(s,conjuntos);
		}
	}
	
	private String nomeDoAtributo(int valor){
		
		String nome;
		
		switch(valor){
			case 0 : nome = "age"; break;
			case 1 : nome = "workclass"; break;
			case 2 : nome = "fnlwgt"; break;
			case 3 : nome = "education"; break;
			case 4 : nome = "educationNum"; break;
			case 5 : nome = "maritalStatus"; break;
			case 6 : nome = "occupation"; break;
			case 7 : nome = "relationship"; break;
			case 8 : nome = "race"; break;
			case 9 : nome = "sex"; break;
			case 10 : nome = "capitalGain"; break;
			case 11 : nome = "capitalLoss"; break;
			case 12 : nome = "hoursPerWeek"; break;
			case 13 : nome = "nativeCountry"; break;
			case 14 : nome = "classe"; break;
			default : nome = "erro"; break;
		}
		
		return nome;
		
	}

}
