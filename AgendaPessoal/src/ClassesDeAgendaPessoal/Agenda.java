package ClassesDeAgendaPessoal;
import java.util.*;
import java.io.*;
/**
 * A classe: <b>Agenda</b> uma coleção de itens de agenda. Ultiliza TreeMap, para organizar os Itens Lembrete, Meta e Evento
 * <p>
 * Usada para organizar os Itens de Agenda, oferecendo relatorios e salvando em um arquivo, ultiliza a serializacao
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
public class Agenda implements Serializable {

	/**colecao para os itens de agenda Meta, chave e um Integer e organiza em ordem crescente por prioridade da Meta*/
	private TreeMap<Integer, Meta> treeMeta = new TreeMap<Integer, Meta>();
	/**colecao para os itens de agenda Lembrete, chave e um Integer e organiza em ordem crescente por alerta do Lembrete*/
	private TreeMap<Integer, Lembrete> treeLembrete = new TreeMap<Integer, Lembrete>();
	/**colecao para os itens de agenda Evento, chave e um String e organiza em ordem alfabetica por local do Evento*/
	private TreeMap<String, Evento> treeEvento = new TreeMap<String, Evento>();

	/**Costrutor para inicializar colecoes(TreeMap) de Meta Lembrete e Evento. E inserido o primeiro elemento em cada colecao de Item de Agenda
	 * @param m primeira Meta a ser inserida na colecao de Meta*
	 * @param l primeira Lembrete a ser inserida na colecao de Lembrete*
	 * @param e primeira Evento a ser inserida na colecao de Evento**/
	public Agenda(Meta m, Lembrete l, Evento e) {
		this.addTreeMeta(m);
		this.addTreeLembrete(l);
		this.addTreeEvento(e);
	}
	/**Costrutor sobrecarregado para criar colecoes(TreeMap) de Meta Lembrete e Evento. Colecoes comecam vazias*/
	public Agenda() {
	}

	/** @return retorna um item Meta registrado na Agenda(busca feita pela chave prioridade da Meta)
	 * @param prioridade nivel de prioridade da Meta*/
	public Meta getMeta(int prioridade) {
		return this.treeMeta.get(prioridade);
	}

	/** @return retorna um item Lembrete registrado na Agenda(busca feita pela chave alerta de Lembrete)
	 * @param alerta quantidade de minutos de antecedencia do Lembrete*/
	public Lembrete getLembrete(int alerta) {
		return this.treeLembrete.get(alerta);
	}


	/** @return retorna um item Evento registrado na Agenda(busca feita pela chave local de Evento)
	 * @param local onde será realizado o evento*/
	public Evento getEvento(String local) {
		return this.treeEvento.get(local);
	}

	/**@return metodo ultilizado na propria classe, retorna todos os itens Meta registrados na Agenda, ordenadas por prioridade*/
	private TreeMap<Integer, Meta> allMeta() {
		return this.treeMeta;
	}

	/**@return metodo ultilizado na propria classe, retorna todos os itens Lembrete registrados na Agenda, ordenados por minutos de antecedencia(alerta)*/
	private TreeMap<Integer, Lembrete> allLembrete() {
		return this.treeLembrete;
	}

	/**@return metodo ultilizado na propria classe, retorna todos os itens Evento registrados na Agenda, ordenados alfabeticamente por local do evento*/
	private TreeMap<String, Evento> allEvento() {
		return this.treeEvento;
	}

	/**adiciona Meta na colecao TreeMeta da Agenda
	 * @param m Meta a ser inserida*/
	public void addTreeMeta(Meta m) {
		this.treeMeta.put(m.getPrioridade(), m);
	}
	
	/**adiciona Lembrete na colecao TreeLembrete da Agenda
	 * @param l Lembrete a ser inserido*/
	public void addTreeLembrete(Lembrete l) {
		this.treeLembrete.put(l.getAlerta(), l);
	}

	/**adiciona Evento na colecao TreeEvento da Agenda
	 * @param e Evento a ser inserido*/
	public void addTreeEvento(Evento e) {
		this.treeEvento.put(e.getLocal(), e);
	}

	/**metodo sobrescrito para imprimir um objeto Agenda ex: {3=(3) Gluten- 'Parar de comer completamente alimentos que contem gluten' (03/05/1995 - 00:00)  -  (16/04/1999 - 23:15) {5=!5! agua- 'encher garrafas de agua, para gelar' (20/04/2007 - 11:44)  -  (15/05/2010 - 15:33){Brasilia=Campus Party- 'Acampar em um vento voltado para a tecnologia' (20/04/2001 - 11:44)  -  (15/05/2006 - 15:33) Brasilia}
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.allMeta());
		dados.append(this.allLembrete());
		dados.append(this.allEvento());
		return dados.toString();
	}

	/**metodo Cria um arquivo nomeArq e inicia o processo de serializacao, para guardar informacoes do objeto instanciado na classe de Uso, pacote Aplicacao
	 * @param a Agenda, conjunto de colecoes de Itens de Agenda, a ser armazenado em disco
	 * @param nomeArq nome do arquivo que guardara a Agenda a*/
	
	public static void gravarArquivoBinario(Agenda a, String nomeArq) {
		File arq = new File(nomeArq);
		try {
			arq.delete();
			arq.createNewFile();

			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(a);
			objOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**@return metodo sobrecarregado porem publico, recupera registros Meta, da Agenda que foi serializada em um arquivo nomeArq.
	 *  Retorna todos os itens Meta registrados nessa Agenda, por ordem crescente de prioridade
	 *  @param nomeArq nome do arquivo em que a Agenda foi serializada*/
	public static TreeMap<Integer, Meta> allMeta(String nomeArq) {
		TreeMap<Integer, Meta> treeMeta = new TreeMap<Integer, Meta>();
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				treeMeta = ((Agenda) (objInput.readObject())).allMeta();
				objInput.close();

			}

		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return treeMeta;
	}
	/**@return metodo sobrecarregado porem publico, recupera registros Lembretes da Agenda que foi serializada em um arquivo nomeArq.
	 *  Retorna todos os itens Lembrete registrados nessa Agenda, por ordem crescente de minutos deantecedencia(alerta)
	 *  @param nomeArq nome do arquivo em que a Agenda foi serializada*/
	public static TreeMap<Integer, Lembrete> allLembrete(String nomeArq) {
		TreeMap<Integer, Lembrete> treeLembrete = new TreeMap<Integer, Lembrete>();
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				treeLembrete = ((Agenda) (objInput.readObject())).allLembrete();
				objInput.close();

			}

		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return treeLembrete;
	}
	/**@return metodo sobrecarregado porem publico, recupera registros Lembretes da Agenda que foi serializada em um arquivo nomeArq.
	 *  Retorna todos os itens Lembrete registrados nessa Agenda, ordenados alfabeticamente por local do evento
	 *  @param nomeArq nome do arquivo em que a Agenda foi serializada*/
	public static TreeMap<String, Evento> allEvento(String nomeArq) {
		TreeMap<String, Evento> treeEvento = new TreeMap<String, Evento>();
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				treeEvento = ((Agenda) (objInput.readObject())).allEvento();
				objInput.close();

			}

	} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return treeEvento;
	}

	/**@return metodo recupera toda a Agenda que foi serializada em um arquivo nomeArq.
	 *  Retorna todos os itens Meta,Lembrete e Evento registrados nessa Agenda.
	 *  @param nomeArq nome do arquivo em que a Agenda foi serializada*/
	public static Agenda allAgenda(String nomeArq) {
		Agenda ag = new Agenda();
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				ag = (Agenda) (objInput.readObject());
				objInput.close();

			}

		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return ag;
	}
	
	/**@return metodo recupera toda a Agenda que foi serializada em um arquivo nomeArq.
	 *  cria uma nova Agenda auxiliar para:<p>
	 *  Retornar todos Meta,Lembrete e Evento limitados em um intervalo de Data relativa as datas finais do Item de Agenda.
	 *  @param nomeArq nome do arquivo em que a Agenda foi serializada
	 *  @param dtInicial Limite inferior do intervalo de Data
	 *  @param dtFinal Limite superior do intervalo de Data
	 *  */
	public static Agenda allAgendaIntervaloDatas(String nomeArq, Data dtInicial, Data dtFinal) {
		Agenda ag = new Agenda();
		Agenda agData = new Agenda();
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				ag = (Agenda) (objInput.readObject());
				objInput.close();

			}
			for (int chave : ag.allMeta().keySet()) {
				if (ag.allMeta().get(chave).getP().getDtFim().compareTo(dtInicial) == 1
						&& ag.allMeta().get(chave).getP().getDtFim().compareTo(dtFinal) == -1)
					agData.addTreeMeta(ag.allMeta().get(chave));
			}
			for (int chave : ag.allLembrete().keySet()) {
				if (ag.allLembrete().get(chave).getP().getDtFim().compareTo(dtInicial) == 1
						&& ag.allLembrete().get(chave).getP().getDtFim().compareTo(dtFinal) == -1)
					agData.addTreeLembrete(ag.allLembrete().get(chave));
			}
			for (String chave : ag.allEvento().keySet()) {
				if (ag.allEvento().get(chave).getP().getDtFim().compareTo(dtInicial) == 1
						&& ag.allEvento().get(chave).getP().getDtFim().compareTo(dtFinal) == -1)
					agData.addTreeEvento(ag.allEvento().get(chave));
			}

		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return agData;
	}

}
