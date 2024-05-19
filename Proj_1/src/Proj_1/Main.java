package Proj_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int count = 0;
    private static List<Entidade> entidadesCadastradas = new ArrayList<>();
    private static List<Pessoa> pessoasCadastradas = new ArrayList<>();
    private static List<Campeonato> campeonatosCadastrados = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        List<String> tipoCamp = new ArrayList<>(Arrays.asList("Pontos corridos", "Fase de Grupo"));

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro");
            System.out.println("2. Criar Campeonato");
            System.out.println("3. Listar Entidades Cadastradas");
            System.out.println("4. Listar Pessoas Cadastradas");
            System.out.println("5. Editar Esportes");
            System.out.println("6. Editar Atletas");
            System.out.println("0. Sair");
            int escolha = teclado.nextInt();
            teclado.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Escolha o tipo de cadastro:");
                    System.out.println("1. Atleta");
                    System.out.println("2. Comissão Técnica");
                    System.out.println("3. Arbitragem");
                    int tipoCadastro = teclado.nextInt();
                    teclado.nextLine();

                    Entidade entidade = escolherOuCriarEntidade(teclado);

                    switch (tipoCadastro) {
                        case 1:
                            cadastrarAtleta(teclado, entidade);
                            break;
                        case 2:
                            cadastrarComissaoTecnica(teclado, entidade);
                            break;
                        case 3:
                            cadastrarArbitragem(teclado, entidade);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    criarCampeonato(teclado, tipoCamp);
                    break;

                case 3:
                    listarEntidadesCadastradas();
                    break;
                case 4:
                    listarPessoasCadastradas(); 
                    break;

                case 5:
                    editarEsportes(teclado);
                    break

                case 0:
                    System.out.println("Encerrando o programa.");
                    teclado.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static Entidade escolherOuCriarEntidade(Scanner teclado) {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Escolher uma entidade existente");
        System.out.println("2. Criar uma nova entidade");
        int escolha = teclado.nextInt();
        teclado.nextLine();

        if (escolha == 1 && !entidadesCadastradas.isEmpty()) {
            System.out.println("Entidades cadastradas:");
            for (int i = 0; i < entidadesCadastradas.size(); i++) {
                System.out.println((i + 1) + ". " + entidadesCadastradas.get(i).getNome());
            }
            int escolhaEntidade = teclado.nextInt();
            teclado.nextLine();
            if (escolhaEntidade >= 1 && escolhaEntidade <= entidadesCadastradas.size()) {
                return entidadesCadastradas.get(escolhaEntidade - 1);
            } else {
                System.out.println("Escolha inválida, criando nova entidade.");
            }
        }

        System.out.println("Nome da nova entidade:");
        String nomeEntidade = teclado.nextLine();
        System.out.println("Nome do responsável:");
        String nomeResponsavel = teclado.nextLine(); // Lê apenas o nome do responsável
        Entidade novaEntidade = new Entidade(nomeEntidade, nomeResponsavel); // Cria uma nova Entidade com nome e responsável
        entidadesCadastradas.add(novaEntidade);
        return novaEntidade;
    }
    

    private static void cadastrarAtleta(Scanner teclado, Entidade entidade) {
        System.out.println("Cadastro de Atleta");
        System.out.println("Nome:");
        String nomeAtleta = teclado.nextLine();
        System.out.println("CPF:");
        String cpfAtleta = teclado.nextLine();
        System.out.println("Foto:");
        String fotoAtleta = teclado.nextLine();
        System.out.println("Posição:");
        String posicaoAtleta = teclado.nextLine();
        System.out.println("RA:");
        String raAtleta = teclado.nextLine();

        Atleta atleta = new Atleta(nomeAtleta, cpfAtleta, entidade, fotoAtleta, count++, posicaoAtleta, raAtleta);
        System.out.println("Atleta cadastrado:\n" + atleta);
        // Adiciona o novo atleta à lista de pessoas cadastradas
        pessoasCadastradas.add(atleta);
    }

    private static void cadastrarComissaoTecnica(Scanner teclado, Entidade entidade) {
        System.out.println("Cadastro de Comissão Técnica");
        System.out.println("Nome:");
        String nomeComissao = teclado.nextLine();
        System.out.println("CPF:");
        String cpfComissao = teclado.nextLine();
        System.out.println("Foto:");
        String fotoComissao = teclado.nextLine();
        System.out.println("Cargo:");
        String cargoComissao = teclado.nextLine();
        System.out.println("Esporte:");
        String esporteComissao = teclado.nextLine();

        ComissaoTecnica comissao = new ComissaoTecnica(nomeComissao, cpfComissao, entidade, fotoComissao, cargoComissao, esporteComissao);
        System.out.println("Comissão Técnica cadastrada:\n" + comissao);
         // Adiciona o novo comissao à lista de pessoas cadastradas
         pessoasCadastradas.add(comissao);
    }

    private static void cadastrarArbitragem(Scanner teclado, Entidade entidade) {
        System.out.println("Cadastro de Arbitragem");
        System.out.println("Nome:");
        String nomeArbitragem = teclado.nextLine();
        System.out.println("CPF:");
        String cpfArbitragem = teclado.nextLine();
        System.out.println("Foto:");
        String fotoArbitragem = teclado.nextLine();
        System.out.println("Nome da Mesa:");
        String mesaArbitragem = teclado.nextLine();

        ArrayList<String> nomeMesa = new ArrayList<>();
        nomeMesa.add(mesaArbitragem);

        Arbitragem arbitragem = new Arbitragem(nomeArbitragem, cpfArbitragem, entidade, fotoArbitragem, nomeMesa);
        System.out.println("Arbitragem cadastrada:\n" + arbitragem);
        // Adiciona o novo arbitragem à lista de pessoas cadastradas
        pessoasCadastradas.add(arbitragem);
    }

    private static void criarCampeonato(Scanner teclado, List<String> tipoCamp) throws InterruptedException {
        System.out.println("Qual será o formato do seu campeonato? Digite o número da sua escolha.");
        for (int i = 0; i < tipoCamp.size(); i++) {
            System.out.println((i + 1) + ". " + tipoCamp.get(i));
        }
        int escolhaCamp = teclado.nextInt();
        teclado.nextLine();

        switch (escolhaCamp) {
            case 1: // Pontos corridos
                System.out.println("Você selecionou Pontos Corridos.\n");
                System.out.println("Qual o nome do campeonato com formato Pontos Corridos?");
                String nomeCampPC = teclado.nextLine();
                PontosCorridos CampPC = new PontosCorridos(nomeCampPC);

                System.out.println("Quantas entidades de times terão no campeonato " + CampPC.getNome() + "?");
                int qntEntidadesPC = teclado.nextInt();
                teclado.nextLine();

                for (int k = 0; k < qntEntidadesPC; k++) {
                    Entidade entidade = escolherOuCriarEntidade(teclado);
                    CampPC.addTime(new Time(entidade));
                }

                System.out.println("A tabela de times é a seguinte: \n" + CampPC.mostrarTabela());
                campeonatosCadastrados().add(campPC);
                break;

                case 2: // Fase de Grupos
                System.out.println("Você selecionou Fase de Grupos. Para esse formato é necessário ter mais de 4 entidades inscritas no campeonato.");
                Thread.sleep(3000);
                System.out.println("Qual o nome do campeonato com formato Fase de Grupos?");
                String nomeCampFG = teclado.nextLine();
                FaseGrupos CampFG = new FaseGrupos(nomeCampFG);
            
                System.out.println("Quantas entidades de times terão no campeonato " + CampFG.getNome() + "?");
                int qntEntidadesFG = teclado.nextInt();
                teclado.nextLine();
            
                while (qntEntidadesFG < 4) {
                    System.out.println("Número mínimo de entidades para esse formato são 4. Acrescente mais entidades para prosseguir nesse formato.");
                    System.out.println("Quantas entidades de times terão no campeonato " + CampFG.getNome() + "?");
                    qntEntidadesFG = teclado.nextInt();
                    teclado.nextLine();
                }
            
                for (int k = 0; k < qntEntidadesFG; k++) {
                    System.out.println("Qual o nome da entidade " + (k + 1) + "?");
                    String nomeEntidade = teclado.nextLine();
                    CampFG.addTime(new Time(new Entidade(nomeEntidade, null)));
                }
            
                System.out.println("Quantos grupos terão no campeonato " + CampFG.getNome() + "?");
                int qntGruposFG = teclado.nextInt();
                teclado.nextLine();
                CampFG.criarGrupos(qntGruposFG);
                System.out.println("Realizaremos o cadastro dos grupos e times do " + CampFG.getNome() + ".");
            
                for (int k = 0; k < CampFG.grupos.size(); k++) {
                    System.out.println("Qual será o nome do grupo " + (k + 1) + "?");
                    String group = teclado.nextLine();
                    CampFG.grupos.get(k).setNome(group);
            
                    System.out.println("Quais times você quer que estejam no grupo " + CampFG.grupos.get(k).getNome() + "?");
            
                    ArrayList<Time> timeGrupo = new ArrayList<Time>();
                    ArrayList<Time> listaTimesProv = CampFG.listaTimes;
                    for (int j = 0; j < CampFG.getQntTimes(); j++) {
                        for (int i = 0; i < listaTimesProv.size(); i++) {
                            System.out.println((i + 1) + ". " + listaTimesProv.get(i).getEntidade().getNome());
                        }
                        int escolhaTime = teclado.nextInt();
                        teclado.nextLine();
            
                        if (escolhaTime >= 1 && escolhaTime <= listaTimesProv.size()) {
                            Time time_selec = listaTimesProv.remove(escolhaTime - 1);
                            CampFG.grupos.get(k).timeGrp.add(time_selec);
                            timeGrupo = CampFG.grupos.get(k).timeGrp;
                        }
                    }
                    // Define o grupo para o time selecionado
                    CampFG.grupos.get(k).setGrupo(timeGrupo);
                }
            
                System.out.println("Os grupos e seus respectivos times são: \n" + CampFG.mostrarGrupos());
                campeonatosCadastrados().add(campFG);
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }

    private static void listarEntidadesCadastradas() {
        if (entidadesCadastradas.isEmpty()) {
            System.out.println("Nenhuma entidade cadastrada.");
        } else {
            System.out.println("Entidades cadastradas:");
            for (Entidade entidade : entidadesCadastradas) {
                System.out.println(entidade);
            }
        }
    }
    private static void listarPessoasCadastradas() {
        if (pessoasCadastradas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            System.out.println("\nPessoas cadastradas:");
            for (Pessoa pessoa : pessoasCadastradas) {
                if (pessoa instanceof Atleta) {
                    System.out.println("\nTipo: Atleta");
                } else if (pessoa instanceof ComissaoTecnica) {
                    System.out.println("\nTipo: Comissão Técnica");
                } else if (pessoa instanceof Arbitragem) {
                    System.out.println("\nTipo: Arbitragem");
                } else {
                    System.out.println("Tipo: Desconhecido");
                }
                System.out.println(pessoa);
            }
        }
    }

    private static void editarEsportes(Scanner teclado){
        int escolhaentidade;
        int qntEsportes;
        String nomeEsporte
        
        System.out.println("Qual campeonato você vai editar?");
        for (int i=0; i<campeonatosCadastrados.size(); i++){
            System.out.println(i+"-"+campeonatosCadastrados.get(i).getNome);
        }
        int escolhaCamp = teclado.nextInt();
        Campeonato camp = campeonatosCadastrados.get(escolhaCamp);
    	teclado.nextLine();

        System.out.println("O que deseja fazer?");
        System.out.println("1-Adicionar esportes");
        System.out.println("2-Remover esportes");

        int escolhaAcao = teclado.nextInt(); 
    	teclado.nextLine();

        switch(escolhaAcao){
            case 1:
                System.out.println("A qual entidade serão adicionados esportes?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos esportes serão adicionados?");
                qntEsportes = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntEsportes; i++) {
                    System.out.println("Qual o nome do esporte " + (i+1) + "?");
                    nomeEsporte = teclado.nextLine();
                    Camp.getTimes().get(escolhaentidade).getEntidade().addEsporte(nomeEsporte);
                }
                break;

            case 2:
                System.out.println("De qual entidade serão removidos esportes?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos esportes serão removidos? ("+camp.getTimes().get(i).getEntidade().getEsportes().size()+"atualmente)");
                qntEsportes = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntEsportes; i++) {
                    System.out.println("Qual o nome do esporte " + (i+1) + "?");
                    System.out.println("Disponíveis: ");
                    for (int i=0; i<camp.getTimes().get(i).getEntidade().getEsportes().size(); i++){
                        System.out.println(camp.getTimes().get(i).getEntidade().getEsportes().get(i));
                    }
                    String nomeEsporte = teclado.nextLine();
                    camp.getTimes().get(escolhaentidade).getEntidade().removeEsporte(nomeEsporte);
                }
                break;

                
        }
    }

    private static void editar atletas(){
        
    }
    
}
