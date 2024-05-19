package Proj_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int count = 0; // Variável estática para contar os IDs

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        List<String> tipoCamp = new ArrayList<>(Arrays.asList("Pontos corridos", "Fase de Grupo"));

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro");
            System.out.println("2. Criar Campeonato");
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

                    switch (tipoCadastro) {
                        case 1:
                            System.out.println("Cadastro de Atleta");
                            System.out.println("Nome:");
                            String nomeAtleta = teclado.nextLine();
                            System.out.println("CPF:");
                            String cpfAtleta = teclado.nextLine();
                            System.out.println("Foto:");
                            String fotoAtleta = teclado.nextLine();
                            System.out.println("Entidade:");
                            String entidadeAtleta = teclado.nextLine();
                            System.out.println("Posição:");
                            String posicaoAtleta = teclado.nextLine();
                            System.out.println("RA:");
                            String raAtleta = teclado.nextLine();

                            Entidade entidade1 = new Entidade(entidadeAtleta, null);
                            Atleta atleta = new Atleta(nomeAtleta, cpfAtleta, entidade1, fotoAtleta, count++, posicaoAtleta, raAtleta);
                            System.out.println("Atleta cadastrado:\n" + atleta);
                            break;

                        case 2:
                            System.out.println("Cadastro de Comissão Técnica");
                            System.out.println("Nome:");
                            String nomeComissao = teclado.nextLine();
                            System.out.println("CPF:");
                            String cpfComissao = teclado.nextLine();
                            System.out.println("Foto:");
                            String fotoComissao = teclado.nextLine();
                            System.out.println("Entidade:");
                            String entidadeComissao = teclado.nextLine();
                            System.out.println("Cargo:");
                            String cargoComissao = teclado.nextLine();
                            System.out.println("Esporte:");
                            String esporteComissao = teclado.nextLine();

                            Entidade entidade2 = new Entidade(entidadeComissao, null);
                            ComissaoTecnica comissao = new ComissaoTecnica(nomeComissao, cpfComissao, entidade2, fotoComissao, cargoComissao, esporteComissao);
                            System.out.println("Comissão Técnica cadastrada:\n" + comissao);
                            break;

                        case 3:
                            System.out.println("Cadastro de Arbitragem");
                            System.out.println("Nome:");
                            String nomeArbitragem = teclado.nextLine();
                            System.out.println("CPF:");
                            String cpfArbitragem = teclado.nextLine();
                            System.out.println("Foto:");
                            String fotoArbitragem = teclado.nextLine();
                            System.out.println("Entidade:");
                            String entidadeArbitragem = teclado.nextLine();
                            System.out.println("Nome da Mesa:");
                            String mesaArbitragem = teclado.nextLine();

                            ArrayList<String> nomeMesa = new ArrayList<>();
                            nomeMesa.add(mesaArbitragem);

                            Entidade entidade3 = new Entidade(entidadeArbitragem, null);
                            Arbitragem arbitragem = new Arbitragem(nomeArbitragem, cpfArbitragem, entidade3, fotoArbitragem, nomeMesa);
                            System.out.println("Arbitragem cadastrada:\n" + arbitragem);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
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
                                System.out.println("Qual o nome da entidade " + (k + 1) + "?");
                                String nomeEntidade = teclado.nextLine();
                                CampPC.addTime(new Time(new Entidade(nomeEntidade, null)));
                            }

                            System.out.println("A tabela de times é a seguinte: \n" + CampPC.mostrarTabela());
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
                                CampFG.grupos.get(k).setGrupo(timeGrupo);
                            }

                            System.out.println("Os grupos e seus respectivos times são: \n" + CampFG.mostrarGrupos());
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    teclado.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
