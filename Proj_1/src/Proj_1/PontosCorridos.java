package Proj_1;
import java.util.ArrayList;

public class PontosCorridos extends MataMata {
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	ArrayList<Time> tabela = new ArrayList<Time>();
	ArrayList<Time> classificados = new ArrayList<Time>();
	
	public PontosCorridos(String nome, String premio, int classificacao, ArrayList<Jogo> jogos) {
		super(nome);
		this.jogos = jogos;
	}
	
	public PontosCorridos(String nome) {
		super(nome);
	}
	
	public ArrayList<Time> mostrarTabela() {
		for(int i = 0; i < listaTimes.size(); i++) {
			int j = i + 1;
			int cl = listaTimes.get(j).getClassificacao();
			tabela.add(cl, listaTimes.get(i));
		}
		return tabela;
	}

	@Override
	public String toString() {
		return "";
	}
}