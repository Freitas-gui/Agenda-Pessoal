package ClassesDeAgendaPessoal;
/**
 * A  classe  <b>Lembrete</b> e uma extencao de ItemAgenda, e possui o campo alerta(quantidade de minutos)
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
public class Lembrete extends ItemAgenda {
	/**quantidade de minutos para dar um alerta de antecedencia do inicio do periodo dessa atividade*/
	private int alerta;
	
	/**Costrutor para inicializar valores nos campos titulo, descricao ,p e alerta
	 * @param _alerta quantidade de minutos de antecedencia
	 * @param _titulo titulo do ItemAgenda*
	 * @param _descricao descricao do Item**
	 * @param _p Periodo que o Item dura*/
	public Lembrete(int _alerta, String _titulo, String _descricao, Periodo _p) {
		super(_titulo, _descricao, _p);
		this.setAlerta(_alerta);
	}

	/** @return retornar campo privado: alerta*/
	public int getAlerta() {
		return this.alerta;
	}

	/**metodo para alterar campo privado alerta
  	 * @param _alerta quantidade de minutos de antecedencia do Lembrete*/
	public void setAlerta(int _alerta) {
		this.alerta = _alerta;
	}

	/**metodo sobrescrito para imprimir um objeto Lembrete, ultiliza toString da classe pai ItemAgenda ex: !5! agua- 'encher garrafas de agua, para gelar' (20/04/2007 - 11:44)  -  (15/05/2010 - 15:33)
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("!");
		dados.append(this.getAlerta());
		dados.append("! ");
		dados.append(super.toString());
		return dados.toString();
	}
}
