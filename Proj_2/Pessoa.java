package Proj_2;
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
        
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public abstract String obterNome();
    
    public abstract String obterCpf();
    
    public abstract Entidade obterEntidade();
    
    public abstract String obterFoto();
}