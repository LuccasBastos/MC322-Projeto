package Proj_2;

public class ExcecaoEntidade extends Exception{
    public ExcecaoEntidade(){
        super("Entidade não encontrada. Cadastre a entidade primeiro.");
    }
}
