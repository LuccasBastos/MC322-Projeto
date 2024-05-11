package Proj_1;
import java.util.ArrayList;

public class Campeonato {
	private String nome;
	private String premio;
	ArrayList <Entidade> podio = new ArrayList<Entidade>();
	ArrayList <Time> listaTimes = new ArrayList<Time>();

	
	public Campeonato(String nome, String premio) {
		this.nome = nome;
		this.premio = premio;
	}
	
	public Campeonato(String nome) {
		this.nome = nome;
	}
	
	public void addTime(Time time){
		listaTimes.add(time);
	}
	
	public void removeTime(Time time){
		listaTimes.remove(time);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public ArrayList<Entidade> getPodio() {
		return podio;
	}

	public void setPodio(ArrayList<Entidade> podio) {
		this.podio = podio;
	}

	@Override
	public String toString() {
		return "";
	}
	
}