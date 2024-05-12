package Proj_1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class FaseGrupos extends MataMata {
	private String nomeGrupo, nome;
	private int qntGrupos, qntTimes;
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	ArrayList<ArrayList<Time>> grupos = new ArrayList<ArrayList<Time>>(); //Todos os grupos do campeonato 
	
	//Construtores
	public FaseGrupos(String nome) {
		super(nome);
	}
	
	//Métodos
	public ArrayList<ArrayList<Time>> criarGrupos(int qntdGrupos, int qntTimes){
		setQntGrupos(qntdGrupos);
		setQntTimes(qntTimes);
		for (int i = 0; i < qntdGrupos; i++) {
			ArrayList<Time> novoGrp = new ArrayList<Time>(i);
			grupos.add(novoGrp);
			for (int j = 0; j < qntTimes; j++) {
				novoGrp.add(new Time(nome));
			}
		}
		return grupos;
	}
	
	public ArrayList<ArrayList<Time>> mostrarGrupos(){
		return grupos;
	}
	
	public ArrayList<ArrayList<Time>> classificacaoGrupo() {
		for (int j = 0; j < grupos.size(); j++) {
			Collections.sort(grupos.get(j), Comparator.comparingInt(Time::getClassificacao));
		}
		return grupos;
	}
	
	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	
	public int getQntGrupos() {
		return qntGrupos;
	}
	
	public void setQntGrupos(int qntGrupos) {
		this.qntGrupos = qntGrupos;
	}
	
	public int getQntTimes() {
		return qntTimes;
	}
	
	public void setQntTimes(int qntTimes) {
		this.qntTimes = qntTimes;
	}

	//Método toString
	@Override
	public String toString() {
		return "";
	}
}
