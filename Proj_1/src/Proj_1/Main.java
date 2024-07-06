package Proj_1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Proj_1.ExcecaoCPF;
import Proj_1.ExcecaoEntidade;
import Proj_1.ValidaCPF;

public class Main {
    private static int count = 0;
    private static ArrayList<Entidade> entidadesCadastradas = new ArrayList<>();
    private static ArrayList<Pessoa> pessoasCadastradas = new ArrayList<>();
    private static ArrayList<Campeonato> campeonatosCadastrados = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        JFrame janela = new JFrame("Escolha uma Opção");      // Cria uma janela com o título "Escolha uma Opção"
        janela.setSize(600, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        
        JLabel label = new JLabel("Bem-vindo ao Organizador de Torneios!");     // Cria um label com o texto "Bem-vindo ao Organizador de Torneios"
        label.setBounds(50, 50, 500, 30);    // Define a posição e o tamanho do label
        //janela.add(label);
        
        JTextField campo = new JTextField();     // Cria um campo de texto para input, se quiser uma caixinha de texto com mais de 1 linha tem q usar JtextArea
        campo.setBounds(50, 100, 200, 30);   // Define a posição e o tamanho do campo de texto
        //janela.add(campo);
        
        JButton b_escolha = new JButton("Clique aqui");     // Cria um botão com o texto "Clique aqui"
        b_escolha.setBounds(0, 0, 200, 30);    // Define a posição e o tamanho do botão
        b_escolha.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 1;
                System.out.printf("Voce escolheu %d", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });
        //janela.add(b_escolha);

        JButton b1 = new JButton("Cadastro de Atleta");     // Cria um botão com o texto "1. Cadastro"
        b1.setBounds(50, 200, 200, 30);    // Define a posição e o tamanho do botão
        b1.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            @Override
            public void actionPerformed(ActionEvent e) {
            	Atleta A1 = new Atleta("", "", null, "");
            	
                JFrame janCadastro = new JFrame("Realize o cadastro do atleta");
                janCadastro.setSize(400, 300);
                janCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janCadastro.setLayout(null);

                JLabel labelCadastro = new JLabel("Cadastro de Participantes:");
                labelCadastro.setBounds(80, 20, 200, 15);
                janCadastro.add(labelCadastro);

                JTextField campoNome = new JTextField("(Digite seu nome)");
                campoNome.setBounds(80, 40, 200, 20);
                janCadastro.add(campoNome);
                
                JTextField campoCPF = new JTextField("(Digite seu CPF)");
                campoCPF.setBounds(80, 70, 200, 20);
                janCadastro.add(campoCPF);
                
                JTextField campoEntidade = new JTextField("(Digite sua entidade)");
                campoEntidade.setBounds(80, 100, 200, 20);
                janCadastro.add(campoEntidade);
                
                JTextField campoFoto = new JTextField("(Insira sua foto)");
                campoFoto.setBounds(80, 130, 200, 20);
                janCadastro.add(campoFoto);
                
                JTextField campoRA = new JTextField("(Digite seu RA)");
                campoRA.setBounds(80, 160, 200, 20);
                janCadastro.add(campoRA);
                
                JTextField campoPos = new JTextField("(Digite sua posição)");
                campoPos.setBounds(80, 190, 200, 20);
                janCadastro.add(campoPos);

                JButton bCadastro = new JButton("Cadastrar");
                bCadastro.setBounds(200, 215, 120, 30);
                bCadastro.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            String nome = campoNome.getText();
                            A1.setNome(nome);
                            System.out.printf("Nome cadastrado: %s\n", nome);
                            
                            String cpf = campoCPF.getText();
                            if(!ValidaCPF.isValidCpf(cpf)){         //se cpf NÃO é valido, lança exceção
                                ExcecaoCPF exCPF = new ExcecaoCPF();
                                throw exCPF;
                            }
                            A1.setCpf(cpf);
                            System.out.printf("CPF: %s\n", cpf);
                            
                            String entidade = campoEntidade.getText();
                            if(!entidadesCadastradas.contains(entidade)){       //se entidade não estiver cadastrada, lança exceção
                                ExcecaoEntidade exEnt = new ExcecaoEntidade();
                                throw exEnt;
                            }
                            A1.setEntidade(null);
                            System.out.printf("Entidade: %s\n", entidade);
                            
                            String RA = campoRA.getText();
                            A1.setRa(RA);
                            System.out.printf("RA: %s\n", RA);
                            
                            String posicao = campoPos.getText();
                            A1.setPosicao(posicao);
                            System.out.printf("Posição: %s\n", posicao);
                            janCadastro.dispose(); // Fecha a janela de cadastro após o cadastro
                        }
                        catch(ExcecaoCPF exc){
                            //O que deve ser feito quando um cpf inválido for detectado?

                            System.err.println(exc);
                        }
                        catch(ExcecaoEntidade exc){
                            //O que deve ser feito quando uma entidade não cadastrada for detectada?

                            System.err.println(exc);
                        }
                    }
                });
                janCadastro.add(bCadastro);
                janCadastro.setVisible(true); // Torna a janela de cadastro visível
            }
        });
        janela.add(b1);
        
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.addElement("Futsal");
        listModel.addElement("Vôlei");
        listModel.addElement("Basquete");
        listModel.addElement("Handbol");
        
        JButton b2 = new JButton("Cadastro de Entidade");     // Cria um botão com o texto "1. Cadastro"
        b2.setBounds(50, 200, 200, 30);    // Define a posição e o tamanho do botão
        b2.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            @Override
            public void actionPerformed(ActionEvent e) {
            	Entidade E1 = new Entidade("");
            	
                JFrame janCadastroEnt = new JFrame("Realize o cadastro da entidade");
                janCadastroEnt.setSize(400, 300);
                janCadastroEnt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janCadastroEnt.setLayout(null);

                JLabel labelCadastro = new JLabel("Cadastro de Entidades:");
                labelCadastro.setBounds(80, 20, 200, 15);
                janCadastroEnt.add(labelCadastro);

                JTextField campoNomeEnt = new JTextField("(Digite o nome)");
                campoNomeEnt.setBounds(80, 40, 200, 20);
                janCadastroEnt.add(campoNomeEnt);

                JList<String> campoEsp = new JList<String>(listModel);
                campoEsp.setBounds(80, 70, 200, 80);
                janCadastroEnt.add(campoEsp);
                
                JTextField campoResp = new JTextField("(Responsável da entidade)");
                campoResp.setBounds(80, 170, 200, 20);
                janCadastroEnt.add(campoResp);
               
                JButton bCadastro = new JButton("Cadastrar Entidade");
                bCadastro.setBounds(200, 215, 160, 30);
                bCadastro.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nomeEnt = campoNomeEnt.getText();
                        E1.setNome(nomeEnt);
                        System.out.printf("Nome da entidade: %s\n", nomeEnt);
                                             
                        String resp = campoResp.getText();
                        System.out.printf("Responsável: %s\n", resp);
                        janCadastroEnt.dispose(); // Fecha a janela de cadastro após o cadastro
                    }
                });
                janCadastroEnt.add(bCadastro);
                janCadastroEnt.setVisible(true); // Torna a janela de cadastro visível
            }
        });
        janela.add(b2);
        
        /*JButton b2 = new JButton("2. Criar Campeonato");     // Cria um botão com o texto "2. Criar Campeonato"
        b2.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 2;
                System.out.printf("Voce escolheu %d\n", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });

        JButton b3 = new JButton("3. Listar Entidades Cadastradas");     // Cria um botão com o texto "3. Listar Entidades Cadastradas"
        b3.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 3;
                System.out.printf("Voce escolheu %d\n", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });
        
        JButton b4 = new JButton("4. Listar Pessoas Cadastradas");     // Cria um botão com o texto "4. Listar Pessoas Cadastradas"
        b4.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 4;
                System.out.printf("Voce escolheu %d\n", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });

        JButton b5 = new JButton("5. Editar Esportes");     // Cria um botão com o texto "5. Editar Esportes"
        b5.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 5;
                System.out.printf("Voce escolheu %d\n", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });

        JButton b6 = new JButton("6. Editar Atletas");     // Cria um botão com o texto "6. Editar Atletas"
        b6.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 6;
                System.out.printf("Voce escolheu %d\n", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });*/

        JButton b0 = new JButton("0. Sair");     // Cria um botão com o texto "6. Editar Atletas"
        b0.addActionListener(new ActionListener() {      // Faz algo acontecer quando clicar no botão
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = 0;
                System.out.printf("Voce escolheu %d\n", escolha);   // Nesse caso, printa a escolha no console. Pra mudar oq acontece so mexer nessa funcao actionPerformed
            }
        });

        janela.setSize(800, 600);        // Define o tamanho da janela
        janela.setLayout(new GridLayout(4, 2, 5, 5));     // Define o layout da janela como Grid(os botoes ocupam td a janela, tem varios tipos de layout, se quiser mudar so trocar o GridLayout() por outro tipo de layout)
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Garante que o programa encerre ao fechar a janela ao clicar no botão de fechar
        janela.setVisible(true);        // Torna a janela visível

        janela.add(b1);      // Adiciona o botão 1 à janela
        janela.add(b2);      // Adiciona o botão 2 à janela
        /*janela.add(b3);      // Adiciona o botão 3 à janela
        janela.add(b4);      // Adiciona o botão 4 à janela
        janela.add(b5);      // Adiciona o botão 5 à janela
        janela.add(b6);      // Adiciona o botão 6 à janela
        janela.add(b0);*/      // Adiciona o botão 0 à janela
        //janela.add(label);      // Adiciona o label à janela
        //janela.add(campo);      // Adiciona o campo de texto à janela


        //Scanner teclado = new Scanner(System.in);
        List<String> tipoCamp = new ArrayList<>(Arrays.asList("Pontos corridos", "Fase de Grupo"));

        /*while (true) {
            //System.out.println("Escolha uma opção:");
            //System.out.println("1. Cadastro");
            //System.out.println("2. Criar Campeonato");
            //System.out.println("3. Listar Entidades Cadastradas");
            //System.out.println("4. Listar Pessoas Cadastradas");
            //System.out.println("5. Editar Esportes");
            //System.out.println("6. Editar Atletas");
            //System.out.println("0. Sair");
            //int escolha = teclado.nextInt();
            //teclado.nextLine();

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
                    break;

                case 6:
                    editarAtletas(teclado);
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    teclado.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        }*/
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
                campeonatosCadastrados.add(CampPC);
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
                campeonatosCadastrados.add(CampFG);
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
        String nomeEsporte;
        
        System.out.println("Qual campeonato você vai editar?");
        for (int i=0; i<campeonatosCadastrados.size(); i++){
            System.out.println(i+"-"+campeonatosCadastrados.get(i).getNome());
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
                    camp.getTimes().get(escolhaentidade).getEntidade().addEsporte(nomeEsporte);
                }
                break;

            case 2:
                System.out.println("De qual entidade serão removidos esportes?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos esportes serão removidos? ("+camp.getTimes().get(escolhaentidade).getEntidade().getEsportes().size()+" atualmente)");
                qntEsportes = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntEsportes; i++) {
                    System.out.println("Qual o nome do esporte " + (i+1) + "?");
                    System.out.println("Disponíveis: ");
                    for (int k=0; k<camp.getTimes().get(escolhaentidade).getEntidade().getEsportes().size(); k++){
                        System.out.println(camp.getTimes().get(escolhaentidade).getEntidade().getEsportes().get(k));
                    }
                    nomeEsporte = teclado.nextLine();
                    camp.getTimes().get(escolhaentidade).getEntidade().removeEsporte(nomeEsporte);
                }
                break;

                
        }
    }

    private static void editarAtletas(Scanner teclado){
        int escolhaentidade;
        int qntAtletas;
        Atleta atletaadicionado;
        int escolhaAtleta;
        Atleta atletaremovido;
        String nomeAtleta;
        
        System.out.println("Qual campeonato você vai editar?");
        for (int i=0; i<campeonatosCadastrados.size(); i++){
            System.out.println(i+"-"+campeonatosCadastrados.get(i).getNome());
        }
        int escolhaCamp = teclado.nextInt();
        Campeonato camp = campeonatosCadastrados.get(escolhaCamp);
    	teclado.nextLine();

        System.out.println("O que deseja fazer?");
        System.out.println("1-Adicionar Atletas");
        System.out.println("2-Adicionar Titulares");
        System.out.println("3-Remover Atletas");
        System.out.println("4-Remover Titulares");

        int escolhaAcao = teclado.nextInt(); 
    	teclado.nextLine();

        switch(escolhaAcao){
            case 1:
                System.out.println("A qual time serão adicionados atletas?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos atletas serão adicionados?");
                qntAtletas = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntAtletas; i++) {
                    System.out.println("Qual o nome do atleta " + (i+1) + "?");
                    nomeAtleta = teclado.nextLine();
                    atletaadicionado = new Atleta(nomeAtleta, "000.000.000-00", camp.getTimes().get(escolhaentidade).getEntidade(), "foto", camp.getTimes().size(), "Nenhuma", "000000");
                    camp.getTimes().get(escolhaentidade).addAtleta(atletaadicionado);
                }
                break;

            case 2:
                System.out.println("A qual time serão adicionados titulares?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos atletas serão adicionados?");
                qntAtletas = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntAtletas; i++) {
                    System.out.println("Qual o nome do atleta " + (i+1) + "?");
                    nomeAtleta = teclado.nextLine();
                    atletaadicionado = new Atleta(nomeAtleta, "000.000.000-00", camp.getTimes().get(escolhaentidade).getEntidade(), "foto", camp.getTimes().size(), "Nenhuma", "000000");
                    camp.getTimes().get(escolhaentidade).addTitular(atletaadicionado);
                }
                break;

            case 3:
                System.out.println("De qual time serão removidos atletas?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos atletas serão removidos? (" + camp.getTimes().get(escolhaentidade).getAtletas().size() + " atualmente)");
                qntAtletas = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntAtletas; i++) {
                    System.out.println("Qual atleta será removido ?");
                    System.out.println("Disponíveis: ");
                    for (int k=0; k<camp.getTimes().get(escolhaentidade).getAtletas().size(); k++){
                        System.out.println(k+"-"+camp.getTimes().get(escolhaentidade).getAtletas().get(k).obterNome());
                    }
                    escolhaAtleta = teclado.nextInt(); 
                    teclado.nextLine();
                    atletaremovido = camp.getTimes().get(escolhaentidade).getAtletas().get(escolhaAtleta);
                    camp.getTimes().get(escolhaentidade).removeAtleta(atletaremovido);
                }
                break;

            case 4:
                System.out.println("De qual time serão removidos titulares?");
                for (int i=0; i<camp.getTimes().size();i++){
                    System.out.println(i+"-"+camp.getTimes().get(i).getEntidade().getNome());
                }
                escolhaentidade = teclado.nextInt(); 
                teclado.nextLine();
                
                System.out.println("Quantos titulares serão removidos? (" + camp.getTimes().get(escolhaentidade).getTitulares().size() + " atualmente)");
                qntAtletas = teclado.nextInt(); 
                teclado.nextLine();
                
                for(int i = 0; i < qntAtletas; i++) {
                    System.out.println("Qual titular será removido ?");
                    System.out.println("Disponíveis: ");
                    for (int k=0; k<camp.getTimes().get(escolhaentidade).getTitulares().size(); k++){
                        System.out.println(k+"-"+camp.getTimes().get(escolhaentidade).getTitulares().get(k).obterNome());
                    }
                    escolhaAtleta = teclado.nextInt(); 
                    teclado.nextLine();
                    atletaremovido = camp.getTimes().get(escolhaentidade).getTitulares().get(escolhaAtleta);
                    camp.getTimes().get(escolhaentidade).removeTitular(atletaremovido);
                }
                break;
                
        }
    }
    
}