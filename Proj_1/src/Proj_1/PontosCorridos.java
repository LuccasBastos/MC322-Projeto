package Proj_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PontosCorridos extends MataMata {
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	ArrayList<Time> tabela = new ArrayList<Time>();
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
	public ArrayList<Time> mostrarTabela() {
		Collections.sort(tabela, Comparator.comparingInt(Time::getClassificacao));
		return tabela;
	}
	
	public ArrayList<Time> classificados() {
		Collections.sort(tabela, Comparator.comparingInt(Time::getClassificacao));
		ArrayList<Time> clas = new ArrayList<Time>();
		for (int i = 0; i < 7; i++) {
			clas.add(tabela.get(i));
		}
		return clas;
	}

	//Método toString
	@Override
	public String toString() {
		return "";
	}
}