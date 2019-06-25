package Aplicacao;
import ClassesDeAgendaPessoal.Agenda;
import ClassesDeAgendaPessoal.Data;
import ClassesDeAgendaPessoal.Evento;
import ClassesDeAgendaPessoal.Horario;
import ClassesDeAgendaPessoal.Lembrete;
import ClassesDeAgendaPessoal.Meta;
import ClassesDeAgendaPessoal.Periodo;

public class Uso {
	//falta separar do pacote, pacote aplication
	public static void main(String args[]) {
		try {
			//Inicializacao de Data , Horario e Periodo
			Data dt1 = new Data(03,05,1995);
			Data dt2 = new Data(16,04,1999);
			Data dt3 = new Data(21,06,2019);
			Horario h1 = new Horario(23,15);
			Horario h3 = new Horario(9,20);
			Horario h2 = new Horario();
			Periodo p1 = new Periodo(dt1,h2,dt2,h1);
			Periodo p2 = new Periodo(20,04,2001,11,44,15,5,2006,15,33);
			Periodo p3 = new Periodo(dt2,h3,dt3,h2);
			Periodo p4 = new Periodo(20,04,2007,11,44,15,5,2010,15,33);
			
			//Inicializacao de Data , Horario e Periodo Meta, Lembrete e Evento
			Meta m1 = new Meta(9 , "UFES" , "Passar em todas as matrias direto" , p2);
			Meta m2 = new Meta(3 , "Gluten" , "Parar de comer completamente alimentos que contem gluten" , p1);
			Meta m3 = new Meta(4 , "Livro" , "Terminar leitura de todos os livros presentes em minha estante " , p3);
			Meta m4 = new Meta(8 , "Java" , "Aprender a desenvolver projetos web, desktop e mobile" , p4);
			
			Lembrete l1 = new Lembrete (15, "Jantar","Tirar o frango do forno", p4);
			Lembrete l2 = new Lembrete (7, "Aniversario","Dar parabens para o Joaquino", p4);
			Lembrete l3 = new Lembrete (25, "Cachorro","colocar a racao do cachorro", p4);
			Lembrete l4 = new Lembrete (5, "agua","encher garrafas de agua, para gelar", p4);
			
			Evento e1= new Evento("FitaVida", "Montar slackline na UFES e praticar esporte com amigos", p2,"Redario");
			Evento e2= new Evento("Campus Party", "Acampar em um vento voltado para a tecnologia", p2,"Brasilia");
			Evento e3= new Evento("Ferias", "Termino do semestre na faculdade , comeco da viagem", p2,"Itacare");
			Evento e4= new Evento("Maratona de Programacao", "Competicao de programacao entre equipe de estudantes ", p2,"Vitoria");
			
			//Inicializa Agenda
			Agenda a = new Agenda(m1,l1,e1);
			a.addTreeMeta(m2);
			a.addTreeMeta(m3);
			a.addTreeMeta(m4);
			a.addTreeEvento(e2);
			a.addTreeEvento(e3);
			a.addTreeEvento(e4);
			a.addTreeLembrete(l2);
			a.addTreeLembrete(l3);
			a.addTreeLembrete(l4);
			
			//Serializacao
			Agenda.gravarArquivoBinario(a,"arqTeste");
			
			System.out.println(Agenda.allMeta("arqTeste"));
			
			System.out.println(Agenda.allLembrete("arqTeste"));
			
			System.out.println(Agenda.allEvento("arqTeste"));
			
			System.out.println(Agenda.allAgenda("arqTeste"));
			
			Data ini = new Data(13,06,2000);
			Data fim = new Data(13,06,2008);
			System.out.println(Agenda.allAgendaIntervaloDatas("arqTeste",ini,fim));
		
		}catch(Exception e){
			System.out.println("Erro");
		}
	}
}