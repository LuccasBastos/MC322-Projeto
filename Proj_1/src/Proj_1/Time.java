package Proj_1;
import java.util.ArrayList;

public class Time {
    private ArrayList<Atleta> atletas;
    private ArrayList<Atleta> titulares;
    private int classificacao;
    private String esporte;
    private Entidade entidade;
    private int vitorias;
    private int derrotas;
    private Atleta capitao;
    private String grupo;

    //Construtor completo
    public Time(ArrayList<Atleta> atletas, ArrayList<Atleta> titulares, int classificacao, String esporte, Entidade entidade, int vitorias, int derrotas, Atleta capitao, String grupo){
        this.atletas = atletas;
        this.titulares = titulares;
        this.classificacao = classificacao;
        this.esporte = esporte;
        this.entidade = entidade;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.capitao = capitao;
        this.grupo = grupo;
    }

    //Construtor sem grupo, classificação, vitórias e derrotas
    public Time(ArrayList<Atleta> atletas, ArrayList<Atleta> titulares, String esporte, Entidade entidade, Atleta capitao){
        this.atletas = atletas;
        this.titulares = titulares;
        this.classificacao = 999;
        this.esporte = esporte;
        this.entidade = entidade;
        this.vitorias = 0;
        this.derrotas = 0;
        this.capitao = capitao;
        this.grupo = "Nenhum";
    }

    //Construtor somente com lista de atletas, esporte e entidade
    public Time(ArrayList<Atleta> atletas, String esporte, Entidade entidade){
        this.atletas = atletas;
        this.titulares = new ArrayList<>();
        this.classificacao = 999;
        this.esporte = esporte;
        this.entidade = entidade;
        this.vitorias = 0;
        this.derrotas = 0;
        this.grupo = "Nenhum";
    }

    //Construtor somente com entidade
    public Time(Entidade entidade){
        this.atletas = new ArrayList<>(
        this.titulares = new ArrayList<>();
        this.classificacao = 999;
        this.entidade = entidade;
        this.vitorias = 0;
        this.derrotas = 0;
        this.grupo = "Nenhum";
    }

    //Getters e Setters
    public ArrayList<Atleta> getAtletas() {
        return atletas;
    }

    public ArrayList<Atleta> getTitulares() {
        return titulares;
    }

    public int getClassificacao() {
        return classificacao;
    }
    
    public String getEsporte() {
        return esporte;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public Atleta getCapitao() {
        return capitao;
    }

    public String getGrupo() {
        return grupo;
    }
    
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setCapitao(Atleta capitao) {
        this.capitao = capitao;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    //Métodos
    public boolean addAtleta(Atleta atleta){
        if (atletas.contains(atleta)){
            return false;
        }
        else{
            atletas.add(atleta);
            return true;
        }
    }

    //Remove um atleta da lista de atletas. Se ele estiver na lista de titulares, remove dela também
    public boolean removeAtleta(Atleta atleta){
        if (atletas.contains(atleta)){
            atletas.remove(atleta);
            if (titulares.contains(atleta)) {
                titulares.remove(atleta);
            }
            return true;
        }
        else{
            return false;
        }
    }

    //Adiciona um atleta à lista de atletas titulares. Se ele não estiver na lista de atletas do time, adiciona à ela também
    public boolean addTitular(Atleta titular){
        if (titulares.contains(titular)){
            return false;
        }
        else{
            titulares.add(titular);
            if (!atletas.contains(titular)){
                atletas.add(titular);
            }
            return true;
        }
    }

    public boolean removeTitular(Atleta titular){
        if (titulares.contains(titular)){
            titulares.remove(titular);
            return true;
        }
        else{
            return false;
        }
    }
}
