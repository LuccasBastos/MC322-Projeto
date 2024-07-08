
package Proj_2;

import java.util.ArrayList;

public class Jogo {
	private Campeonato tipo;
	private String fase;
	private String local;
	private String modalidade;
	private Arbitragem arbitros;
	ArrayList<Integer> resultado = new ArrayList<Integer>();
	private Atleta destaquePart;
	ArrayList<Integer> data = new ArrayList<Integer>();
	private ArrayList<Time> confronto;
	private Time vencedor;			//Adicionei a propriedade vencedor
	
	public Jogo (Campeonato tipo, String fase, String local, String modalidade, Arbitragem arbitros, ArrayList<Integer> resultado, Atleta destaquePart, ArrayList<Integer> data, ArrayList<Time> confronto) {
		this.tipo = tipo;
		this.fase = fase;
		this.local = local;
		this.modalidade = modalidade;
		this.arbitros = arbitros;
		this.resultado = resultado;
		this.destaquePart = destaquePart;
		this.data = data;
		this.confronto = confronto;
	}
	
	//Getters e setters
	public Campeonato getTipo(){
		return tipo;
	}

	public void setTipo(Campeonato tipo){
		this.tipo = tipo;
	}

	public String getFase(){
		return fase;
	}

	public void setFase(String fase){
		this.fase = fase;
	}

	public String getLocal(){
		return local;
	}

	public void setLocal(String local){
		this.local = local;
	}

	public String getModalidade(){
		return modalidade;
	}

	public void setModalidade(String modalidade){
		this.modalidade = modalidade;
	}
	
	public Arbitragem getArbitros(){
		return arbitros;
	}

	public void setArbitros(Arbitragem arbitros){
		this.arbitros = arbitros;
	}

	public ArrayList<Integer> getResultado (){
		return resultado;
	}

	public void setResultado(int time1, int time2){
		this.resultado.set(1,time1);
		this.resultado.set(2,time2);
	}

	public Atleta getDestaque (){
		return destaquePart;
	}

	public void setDestaque(Atleta destaquePart){
		this.destaquePart = destaquePart;
	}

	public ArrayList<Integer> getData (){
		return data;
	}

	public void setData(ArrayList<Integer> data){
		this.data = data;
	}

	public ArrayList<Time> getConfronto (){
		return confronto;
	}

	public void setConfronto(ArrayList<Time> confronto){
		this.confronto = confronto;
	}	

	//Metodos
	public String toString() {
		return ("Tipo do campeonato: " + tipo +
				", Fase do campeonato: " + fase +
				", Local do jogo: " + local + 
				", Modalidade do jogo: " + modalidade +
				", Arbitros: " + arbitros + 
				", Resultado: " + resultado +
				", Destaque da partida: " + destaquePart +
				", Data do jogo: " + data +
				", Confronto: " + confronto);
	}
	
	public Time defVencedor(int time1, int time2) {
		setResultado(time1, time2);
		if(time1 > time2){
			this.vencedor = this.confronto.get(0);
			return vencedor;
		}
		if(time1 == time2){
			System.err.println("O confronto resultou em empate!");
			return null;
			}
		else{
			this.vencedor = this.confronto.get(1);
			return vencedor;	
		}
	}
	
}
