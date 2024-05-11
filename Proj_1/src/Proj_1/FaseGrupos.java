package Proj_1;
import java.util.ArrayList;

public class FaseGrupos extends MataMata {
	String nomeGrupo;
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	ArrayList<Time> agrupamento = new ArrayList<Time>();
	ArrayList<Entidade> listaGrupo = new ArrayList<Entidade>();

	public FaseGrupos(String nome, String premio) {
		super(nome);
	}
		
	public ArrayList<Entidade> mostrarGrupo(String nomeGrupo) {
		for (int i = 0; i < agrupamento.size(); i++) {
			listaGrupo.add(agrupamento.get(i).getEntidade());
		}
		return listaGrupo;
	}

	@Override
	public String toString() {
		return "";
	}
}
