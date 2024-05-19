package Proj_1;
import java.util.ArrayList;

public class Entidade {
    private static int count = 0;
    private String nome;
    private int id;
    private ArrayList<String> esportes;
    private Pessoa resp;

    //Construtor "completo"
    public Entidade(String nome, ArrayList<String> esportes, Pessoa resp){
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

    //Construtor somente com nome da Entidade
    public Entidade(String nome){
        this.id = count++;
        this.nome = nome;
        this.esportes = new ArrayList<>();
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getEsportes() {
        return esportes;
    }

    public Pessoa getResp() {
        return resp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResp(Pessoa resp) {
        this.resp = resp;
    }

    //Métodos
    public boolean addEsporte(String esporte){
        if (esportes.contains(esporte)){
            return false;
        }
        else{
            esportes.add(esporte);
            return true;
        }
    }

    public boolean removeEsporte(String esporte){
        if (esportes.contains(esporte)) {
            esportes.remove(esporte);
            return true;
        }
        else{
            return false;
        }
    }
}