package ClassesDeAgendaPessoal;
/**
 * A  classe  <b>Evento</b> e uma extencao de ItemAgenda, e possui o campo local(onde ser� realizado o evento)
 * <p>
 * Implementa a interface Serializable, para permitir que as suas inst�ncias possam
 * ser usadas numa serializa��o (por exemplo, grava��o em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
public class Evento extends ItemAgenda {
	/** nome do local(onde ser� realizado o evento)*/
	private String local;

	/**Costrutor para inicializar valores nos campos titulo, descricao ,p e local
	 * @param _local onde ser� realizado o evento
	 * @param _titulo titulo do ItemAgenda*
	 * @param _descricao descricao do Item**
	 * @param _p Periodo que o Item dura*/
	public Evento(String _titulo, String _descricao, Periodo _p, String _local) {
		super(_titulo, _descricao, _p);
		this.setLocal(_local);
	}

	/** @return retornar campo privado: local*/
	public String getLocal() {
		return this.local;
	}

	/**metodo para alterar campo privado local
  	 * @param _local onde ser� realizado o evento*/
	public void setLocal(String _local) {
		this.local = _local;
	}

	/**metodo sobrescrito para imprimir um objeto local, ultiliza toString da classe pai ItemAgenda ex: Campus Party- 'Acampar em um vento voltado para a tecnologia' (20/04/2001 - 11:44)  -  (15/05/2006 - 15:33) Brasilia
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(super.toString());
		dados.append(this.local);
		return dados.toString();
	}

}
