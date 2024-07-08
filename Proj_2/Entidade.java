package Proj_2;

import java.util.ArrayList;

public class Entidade {
    private static int count = 0;
    private String nome;
    private int id;
    private ArrayList<String> esportes;
    private String respNome; // Nome do responsável

    // Construtor "completo"
    public Entidade(String nome, ArrayList<String> esportes, String respNome) {
        this.id = count++;
        this.nome = nome;
        this.esportes = esportes;
        this.respNome = respNome;
    }

    // Construtor somente com nome da Entidade e responsável
    public Entidade(String nome, String respNome) {
        this.id = count++;
        this.nome = nome;
        this.esportes = new ArrayList<>();
        this.respNome = respNome;
    }

    // Construtor somente com nome da Entidade
    public Entidade(String nome) {
        this.id = count++;
        this.nome = nome;
        this.esportes = new ArrayList<>();
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getEsportes() {
        return esportes;
    }

    public String getRespNome() {
        return respNome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRespNome(String respNome) {
        this.respNome = respNome;
    }

    // Métodos
    public boolean addEsporte(String esporte) {
        if (esportes.contains(esporte)) {
            return false;
        } else {
            esportes.add(esporte);
            return true;
        }
    }

    public boolean removeEsporte(String esporte) {
        return esportes.remove(esporte);
    }

    @Override
    public String toString() {
        return "Entidade [ID: " + id + ", Nome: " + nome + ", Esportes: " + esportes + 
               ", Responsável: " + respNome + "]";
    }
}
