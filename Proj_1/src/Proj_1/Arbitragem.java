package Proj_1;
import java.util.ArrayList;

public class Arbitragem extends Pessoa {
    private ArrayList<String> nomeMesa;

    public Arbitragem(String nome, String cpf, Entidade entidade, String foto, ArrayList<String> nomeMesa) {
        super(nome, cpf, entidade, foto);
        this.nomeMesa = nomeMesa;
    }

    public ArrayList<String> getNomeMesa() {
        return nomeMesa;
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
        StringBuilder sb = new StringBuilder();
        sb.append("\n###############\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Entidade: ").append(entidade.getNome()).append("\n"); // Chama toString() da entidade para obter apenas o nome
        sb.append("Foto: ").append(foto).append("\n");
        sb.append("Nome da Mesa: ");
        for (String nomeArbitro : nomeMesa) {
            sb.append(nomeArbitro).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Remover a vírgula extra no final
        sb.append("\n###############\n");
        return sb.toString();
    }

    
}
