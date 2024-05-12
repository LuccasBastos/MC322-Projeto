package Proj_1;
import java.util.ArrayList;

public class Entidade {
    private static int count = 0;
    private String nome;
    private int id;
    private ArrayList<Integer> esportes;
    private Pessoa resp;

    //Construtor "completo"
    public Entidade(String nome, ArrayList<Integer> esportes, Pessoa resp){
        this.id = count++;
        this.nome = nome;
        this.esportes = esportes;
        this.resp = resp;
    }

    //Construtor somente com nome da Entidade e responsável
    public Entidade(String nome, Pessoa resp){
        this.id = count++;
        this.nome = nome;
        this.esportes = new ArrayList<>();
        this.resp = resp;
    }
}
