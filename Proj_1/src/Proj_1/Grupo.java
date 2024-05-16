package Proj_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Grupo {
	private String nomeGrp;
	private Entidade ent;
	ArrayList <Time> timeGrp = new ArrayList <Time>();
	public int qntTimes = 4;
	
	//Construtores
	public Grupo(String nome, ArrayList<Time> timeGrp) {
		this.nomeGrp = nome;
		this.timeGrp = timeGrp;
	}
	
	public Grupo(String nome) {
		this.nomeGrp = nome;

	}
	
	public Grupo() {
	}
	
	//Métodos
	public void addTime() {
		timeGrp.add(new Time(ent));
	}
	
	public void removeTime() {
		timeGrp.remove(new Time(ent));
	}
	
	public ArrayList<String> mostrarGrupo(String nome) {
		ArrayList <String> branco = new ArrayList<String>();
		for (int i = 0; i < timeGrp.size(); i++) {
			branco.add(timeGrp.get(i).getEntidade().getNome());
		}
		return branco;
	}
	
	public ArrayList<String> classificacaoGrupo(String nome) {
		Collections.sort(timeGrp, Comparator.comparingInt(Time::getClassificacao));
		
		ArrayList <String> branco = new ArrayList<String>();
		for (int i = 0; i < timeGrp.size(); i++) {
			branco.add(timeGrp.get(i).getClassificacao() + "ª posição: " + timeGrp.get(i).getEntidade().getNome());
		}
		return branco;
	}
	
	public String getNome() {
		return nomeGrp;
	}
	public void setNome(String nomeGrp) {
		this.nomeGrp = nomeGrp;
	}

	public void setGrupo(ArrayList<Time> timeGrupo) {
		// TODO Auto-generated method stub
		
	}	
}
