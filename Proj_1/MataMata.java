package Proj_2;
import java.util.ArrayList;

public class MataMata extends Campeonato{
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();

	//Construtores
	public MataMata(String nome) {
		super(nome);
	}
	
	//Métodos
	public String addConfronto(Time timeA, Time timeB) {
		return timeA.getEntidade().getNome() + " jogará contra " + timeB.getEntidade().getNome();
		/*
		 * Jogo.confronto.add(timeA, timeB);
		 */
	}
	
	public ArrayList<String> fazConfrontos(ArrayList<Time> classificados){
		ArrayList<String> conf = new ArrayList<String>();
		for (int i = 0; i < classificados.size()/2; i = 0) {
			addConfronto(classificados.get(i),classificados.get(classificados.size()-1));
			conf.add(i,classificados.get(i).getEntidade().getNome() + " jogará contra " + classificados.get(classificados.size()-1).getEntidade().getNome());
			classificados.remove(i);
			classificados.remove(classificados.size()-1);
		}
		return conf;
	}

	//Método toString
	public String toString() {
		return "O Mata Mata do Campeonato " + getNome() + "terá os seguintes jogos:\n" + jogos;
	}
}
