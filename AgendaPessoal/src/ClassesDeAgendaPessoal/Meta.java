package ClassesDeAgendaPessoal;
/**
 * A  classe  <b>Meta</b> e uma extencao de ItemAgenda, e possui o campo int prioridade (nivel de importancia da Meta)
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
public class Meta extends ItemAgenda {
	/**nivel de importancia da Meta*/
	private int prioridade;

	/**Costrutor para inicializar valores nos campos titulo, descricao ,p e prioridade
	 * @param _prioridade nivel de importancia da Meta
	 * @param _titulo titulo do ItemAgenda*
	 * @param _descricao descricao do Item**
	 * @param _p Periodo que o Item dura*/
	public Meta(int _prioridade, String _titulo, String _descricao, Periodo _p) {
		super(_titulo, _descricao, _p);
		this.setPrioridade(_prioridade);

	}

	/** @return retornar campo privado: prioridade*/
	public int getPrioridade() {
		return this.prioridade;
	}

	/**metodo para alterar campo privado prioridade
  	 * @param _prioridade nivel de importancia da Meta*/
	public void setPrioridade(int _prioridade) {
		this.prioridade = _prioridade;
	}

	/**metodo sobrescrito para imprimir um objeto Meta, ultiliza toString da classe pai ItemAgenda ex: UFES- 'Passar em todas as matrias direto' (20/04/2001 - 11:44)  -  (15/05/2006 - 15:33
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("(");
		dados.append(this.getPrioridade());
		dados.append(") ");
		dados.append(super.toString());
		return dados.toString();
	}

}