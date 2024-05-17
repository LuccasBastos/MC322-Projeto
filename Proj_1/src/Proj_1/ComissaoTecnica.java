package Proj_1;

public class ComissaoTecnica extends Pessoa {
    private String cargo;
    private String esporte;
    
    public ComissaoTecnica(String nome, String cpf, Entidade entidade, String foto, String cargo, String esporte) {
        super(nome, cpf, entidade, foto);
        this.cargo = cargo;
        this.esporte = esporte;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public String getEsporte() {
        return esporte;
    }
    
    @Override
    public String obterNome() {
        return nome;
    }
    
    @Override
    public String obterCpf() {
        return cpf;
    }
    
    @Override
    public Entidade obterEntidade() {
        return entidade;
    }
    
    @Override
    public String obterFoto() {
        return foto;
    }
    
    @Override
    public String toString() {
        return "\n############### \n"+
               "Nome: " + nome + "\n" +
               "CPF: " + cpf + "\n" +
               "Entidade: " + entidade + "\n" +
               "Foto: " + foto + "\n" +
               "Cargo: " + cargo + "\n" +
               "Esporte: " + esporte+ "\n############### \n";
    }
}
