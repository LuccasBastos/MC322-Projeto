package Proj_1;
public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected Entidade entidade;
    protected String foto;
    
    public Pessoa(String nome, String cpf, Entidade entidade, String foto) {
        this.nome = nome;
        this.cpf = cpf;
        this.entidade = entidade;
        this.foto = foto;
    }
    
    public abstract String obterNome();
    
    public abstract String obterCpf();
    
    public abstract Entidade obterEntidade();
    
    public abstract String obterFoto();
}
