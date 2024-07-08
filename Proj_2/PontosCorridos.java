package Proj_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PontosCorridos extends MataMata {
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	ArrayList<Time> tabela = listaTimes;
	ArrayList<Time> classificados = new ArrayList<Time>();
	
	//Construtores
	public PontosCorridos(String nome) {
		super(nome);
	}
	
	public PontosCorridos(String nome, String premio, int classificacao, ArrayList<Jogo> jogos) {
		super(nome);
		this.jogos = jogos;
	}
	
	//Métodos
	public ArrayList<String> mostrarTabela() {
		Collections.sort(tabela, Comparator.comparingInt(Time::getClassificacao));
		ArrayList <String> branco = new ArrayList<String>();
		for (int i = 0; i < tabela.size(); i++) {
			branco.add("\n" + tabela.get(i).getClassificacao() + "ª posição: " + tabela.get(i).getEntidade().getNome());
		}
		return branco;
	}
	
	public ArrayList<String> classificados() {
		Collections.sort(tabela, Comparator.comparingInt(Time::getClassificacao));
		ArrayList <String> branco = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			branco.add("\n" + tabela.get(i).getClassificacao() + "ª posição: " + tabela.get(i).getEntidade().getNome());
		}
		return branco;
	}

	//Método toString
	public String toString() {
		return "";
	}
}