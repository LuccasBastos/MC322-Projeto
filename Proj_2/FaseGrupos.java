
package Proj_2;
import java.util.ArrayList;

public class FaseGrupos extends MataMata {
	private int qntGrupos, qntTimes;
	ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	ArrayList<Grupo> grupos = new ArrayList<Grupo>(); //Todos os grupos do campeonato
	
	//Construtores
	public FaseGrupos(String nome) {
		super(nome);
		this.qntTimes = 4;
	}
	
	//Métodos
	public ArrayList<Grupo> criarGrupos(int qntdGrupos){
		setQntGrupos(qntdGrupos);
		for (int i = 0; i < qntdGrupos; i++) {
				grupos.add(new Grupo());
			}
		return grupos;
	}
	
	public ArrayList<String> mostrarGrupos(){
		ArrayList <String> branco = new ArrayList<String>();
		for (int i = 0; i < grupos.size(); i++) {
			branco.add(grupos.get(i).getNome() + ": ");
			for (int j = 0; j < grupos.get(i).timeGrp.size(); j++) {
			branco.add(grupos.get(i).timeGrp.get(j).getEntidade().getNome());
			}
			branco.add("\n");
		}
		return branco;
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
		this.qntTimes = 4;
	}
	
	public ArrayList<Grupo> getGrupos (){
		return grupos;
	}

	public void setData(ArrayList<Grupo> grupos){
		this.grupos = grupos;
	}

	//Método toString
	public String toString() {
		return "";
	}
}
