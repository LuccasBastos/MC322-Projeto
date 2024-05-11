package Proj_1;
import java.util.ArrayList;

public class MataMata extends Campeonato{
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();

	public MataMata(String nome) {
		super(nome);
	}
	
	public void addConfronto(Time timeA, Time timeB) {
		jogos.add(null);
	}
	
	public void fazConfrontos(ArrayList<Time> classificados){		
		for (int i = 0; i < classificados.size()/2; i++) {
			addConfronto(classificados.get(i),classificados.get(classificados.size()));
			classificados.remove(i);
			classificados.remove(classificados.size());
		}
	}

	@Override
	public String toString() {
		return "";
	}
	
	
}
