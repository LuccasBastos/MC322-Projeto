package Proj_1;

public class ExcecaoEntidade extends Exception{
    public ExcecaoEntidade(){
        super("Entidade não encontrada. Cadastre a entidade primeiro.");
    }
}
