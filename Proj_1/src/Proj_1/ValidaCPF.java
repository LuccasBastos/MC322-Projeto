package Proj_1;

public class ValidaCPF {
    public boolean isValidCpf(String cpf){
        boolean igual = true;
        int[] num_cpf = new int[11];
        String new_cpf = cpf;

        //1. Remove "-" e "." do cpf
        new_cpf = new_cpf.replaceAll("\\." , "");
        new_cpf = new_cpf.replaceAll("-" , "");

        //2. CPF tem 11 dígitos?
        if (new_cpf.length() != 11) {
            return false;
        }

        //3.1 Todos os dígitos são iguais?
        for(int i=1; i<new_cpf.length(); i++){
            if (new_cpf.charAt(i-1) != new_cpf.charAt(i)){
                igual = false;
                break;
            }
        }

        //3.2 Se forem todos iguais retorna falso (CPF é falso)
        if (igual){
            return false;
        }

        //4.1 Cálculo dos dígitos verificadores
        num_cpf[9] = 0;
        num_cpf[10] = 0;
        for (int i=0; i<9; i++){                                        //cria uma array com os 9 primeiros dígitos do CPF
            num_cpf[i] = Character.getNumericValue(new_cpf.charAt(i));  //atribui o valor numérico do caracter i da String cpf à posição i de num_cpf
            num_cpf[9] += num_cpf[i]*(i+1);                             //multiplica cada algarismo do cpf por sua posição (de 1 a 9) e adiciona a num_cpf[9]
            num_cpf[10] += num_cpf[i]*i;                                //multiplica cada algarismo do cpf por sua posição (de 0 a 8) e adiciona ao num_cpf[10]
        }
        num_cpf[9] %= 11;
        num_cpf[10] += num_cpf[9]*9;
        num_cpf[10] %= 11;

        //4.2 Varificação dos dígitos verificadores, se o 10º OU o 11º número forem diferentes, retorna falso
        if (num_cpf[9] != Character.getNumericValue(new_cpf.charAt(9)) || num_cpf[10] != Character.getNumericValue(new_cpf.charAt(10))){
            return false;
        }

        //retorna true caso tenha passado por todas as condições anteriores
        return true;
    }
}
