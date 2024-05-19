package Proj_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner teclado = new Scanner(System.in);
		List<String> tipoCamp = new ArrayList<>(Arrays.asList("Pontos corridos", "Fase de Grupo"));
		
		System.out.println("Qual será o formato do seu campeonato? Digite o número da sua escolha.");
		for (int i = 0; i < tipoCamp.size(); i++) {
			System.out.println((i + 1) + ". " + tipoCamp.get(i));
			}
		int escolha = teclado.nextInt();
		teclado.nextLine();

		switch (escolha) {
			case 1: // Pontos corridos
				System.out.println("Você selecionou Pontos Corridos.\n");
				System.out.println("Qual o nome do campeonato com formato Pontos Corridos?");
				String nomeCamp = teclado.nextLine(); 
				PontosCorridos Camp = new PontosCorridos(nomeCamp);
				
				System.out.println("Quantas entidades de times terão no campeonato " + Camp.getNome() + "?");
				int qntEntidades = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int k = 0; k < qntEntidades; k++) {
					System.out.println("Qual o nome da entidade " + (k+1) + "?");
					String nomeEntidade = teclado.nextLine();
					Camp.addTime(new Time(new Entidade(nomeEntidade)));
				}
				
				System.out.println("A tabela de times é a seguinte: \n" + Camp.mostrarTabela());
				
				break;
				
			case 2: // Fase de Grupos
				System.out.println("Você selecionou Fase de Grupos. Para esse formato é necessário ter mais de 4 entidades inscritas no campeonato.");
				Thread.sleep(3000);
				System.out.println("Qual o nome do campeonato com formato Fase de Grupos?");
				String nomeCamp = teclado.nextLine();
				FaseGrupos Camp = new FaseGrupos(nomeCamp);
				
				System.out.println("Quantas entidades de times terão no campeonato " + Camp.getNome() + "?");
				int qntEntidades = teclado.nextInt(); 
				teclado.nextLine();
				
				while (qntEntidades < 4) {
					System.out.println("Número mínimo de entidades para esse formato são 4. Acrescente mais entidades para prosseguir nesse formato.");
					System.out.println("Quantas entidades de times terão no campeonato " + Camp.getNome() + "?");
					qntEntidades = teclado.nextInt(); 
					teclado.nextLine();
				}
				
				for(int k = 0; k < qntEntidades; k++) {
					System.out.println("Qual o nome da entidade " + (k+1) + "?");
					String nomeEntidade = teclado.nextLine();
					Camp.addTime(new Time(new Entidade(nomeEntidade)));
				}
				
				System.out.println("Quantos grupos terão no campeonato " + Camp.getNome() + "?");
				int qntGrupos = teclado.nextInt(); 
				teclado.nextLine();
				Camp.criarGrupos(qntGrupos);
				System.out.println("Realizaremos o cadastro dos grupos e times de " + Camp.getNome() + ".");

				for(int k = 0; k < Camp.grupos.size(); k++) {
					System.out.println("Qual será o nome do grupo " + (k+1) + "?");
					String group = teclado.nextLine();
					Camp.grupos.get(k).setNome(group);
					
					System.out.println("Quais times você quer que esteja no grupo " + Camp.grupos.get(k).getNome() + "?");
					
					ArrayList<Time> timeGrupo = new ArrayList<Time>();
					ArrayList<Time> listaTimesProv = Camp.listaTimes;
					for (int j = 0; j < Camp.getQntTimes(); j++) {
						for (int i = 0; i < listaTimesProv.size(); i++) {
							System.out.println((i + 1) + ". " + listaTimesProv.get(i).getEntidade().getNome());
							}
						int escolhaTime = teclado.nextInt();
						teclado.nextLine();
						
						if (escolhaTime >= 1 && escolhaTime <= listaTimesProv.size()) {
							Time time_selec = listaTimesProv.remove(escolhaTime - 1);
							Camp.grupos.get(k).timeGrp.add(time_selec);
							timeGrupo = Camp.grupos.get(k).timeGrp;
						}
					}
					Camp.grupos.get(k).setGrupo(timeGrupo);
				}
				
				System.out.println("Os grupos e seus respectivos times são: \n" + Camp.mostrarGrupo());

				break;
				
		System.out.println("Deseja realizar alguma ação?");
		System.out.println("1-Adiconar esportes, 2-Remover esportes, 3-Adicionar atletas, 4- Remover atletas, 5-Adicionar titulares, 6-Remover titulares");
		int escolhaalterar = teclado.nextInt();
		teclado.nextLine();

		switch (escolhaalterar) {
			case 1:				
				System.out.println("A qual entidade serão adicionados esportes?");
				for (int i=0; i<Camp.getPodio().size;i++){
					System.out.println(i+"-"+Camp.getPodio().get(i).getNome());
				}
				int escolhaentidade = teclado.nextInt()-1; 
				teclado.nextLine();
				
				System.out.println("Quantos esportes serão adicionados?");
				int qntEsportes = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int i = 0; i < qntEsportes; i++) {
					System.out.println("Qual o nome do esporte " + (i+1) + "?");
					String nomeEsporte = teclado.nextLine();
					Camp.getPodio().get(escolhaentidade).addEsporte(nomeEsporte);
				}
				break;
			case 2:
				System.out.println("De qual entidade serão removidos esportes?");
				for (int i=0; i<Camp.getPodio().size;i++){
					System.out.println(i+"-"+Camp.getPodio().get(i).getNome());
				}
				int escolhaentidade = teclado.nextInt()-1; 
				teclado.nextLine();
				
				System.out.println("Quantos esportes serão removidos?");
				int qntEsportes = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int i = 0; i < qntEsportes; i++) {
					System.out.println("Qual o nome do esporte " + (i+1) + "?");
					String nomeEsporte = teclado.nextLine();
					Camp.getPodio().get(escolhaentidade).removeEsporte(nomeEsporte);
				}
				break;

			case 3:
				System.out.println("A qual time serão adicionados atletas?");
				for (int i=0; i<Camp.getTimes().size;i++){
					System.out.println(i+"-"+Camp.getTimes().get(i).getEntidade().getNome());
				}
				int escolhatime = teclado.nextInt()-1; 
				teclado.nextLine();
				
				System.out.println("Quantos atletas serão adicionados?");
				int qntAtleta = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int i = 0; i < qntAtleta; i++) {
					System.out.println("Qual o nome do atleta " + (i+1) + "?");
					String nomeAtleta = teclado.nextLine();
					Atleta atletaadiconado = new Atleta(nomeAtleta, "000.000.000-00", Camp.getTimes().get(escolhatime).getEntidade(), "foto", Camp.getTimes().size(), "Nenhuma", "000000");
					Camp.getTimes().get(escolhatime).addAtleta(atletaadicionado);
				}
				break;

			case 4:
				System.out.println("De qual time serão removidos atletas?");
				for (int i=0; i<Camp.getTimes().size;i++){
					System.out.println(i+"-"+Camp.getTimes().get(i).getEntidade().getNome());
				}
				int escolhatime = teclado.nextInt()-1; 
				teclado.nextLine();
				
				System.out.println("Quantos atletas serão removidos?");
				int qntAtleta = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int i = 0; i < qntAtleta; i++) {
					System.out.println("Qual o nome do atleta " + (i+1) + "?");
					String nomeAtleta = teclado.nextLine();
					Atleta atletaaremover = new Atleta(nomeAtleta, "000.000.000-00", Camp.getTimes().get(escolhatime).getEntidade(), "foto", Camp.getTimes().size(), "Nenhuma", "000000");
					Camp.getTimes().get(escolhatime).removeAtleta(atletaaaremover);
				}
				break;

			case 5:
				System.out.println("A qual time serão adicionados titulares?");
				for (int i=0; i<Camp.getTimes().size;i++){
					System.out.println(i+"-"+Camp.getTimes().get(i).getEntidade().getNome());
				}
				int escolhatime = teclado.nextInt()-1; 
				teclado.nextLine();
				
				System.out.println("Quantos atletas serão adicionados?");
				int qntAtleta = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int i = 0; i < qntAtleta; i++) {
					System.out.println("Qual o nome do atleta " + (i+1) + "?");
					String nomeAtleta = teclado.nextLine();
					Atleta atletaadiconado = new Atleta(nomeAtleta, "000.000.000-00", Camp.getTimes().get(escolhatime).getEntidade(), "foto", Camp.getTimes().size(), "Nenhuma", "000000");
					Camp.getTimes().get(escolhatime).addTitular(atletaadicionado);
				}
				break;

			case 6:
				System.out.println("De qual time serão removidos titulares?");
				for (int i=0; i<Camp.getTimes().size;i++){
					System.out.println(i+"-"+Camp.getTimes().get(i).getEntidade().getNome());
				}
				int escolhatime = teclado.nextInt()-1; 
				teclado.nextLine();
				
				System.out.println("Quantos atletas serão removidos?");
				int qntAtleta = teclado.nextInt(); 
				teclado.nextLine();
				
				for(int i = 0; i < qntAtleta; i++) {
					System.out.println("Qual o nome do atleta " + (i+1) + "?");
					String nomeAtleta = teclado.nextLine();
					Atleta atletaaremover = new Atleta(nomeAtleta, "000.000.000-00", Camp.getTimes().get(escolhatime).getEntidade(), "foto", Camp.getTimes().size(), "Nenhuma", "000000");
					Camp.getTimes().get(escolhatime).removeTitular(atletaaaremover);
				}
				break;
				
			}
		}	
	}
}
