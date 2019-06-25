package ClassesDeAgendaPessoal;
import java.io.Serializable;
/**
 * A  classe abstrata <b>ItemAgenda</b> possui: titulo, descricao e um periodo
 * <p>
 * Usada para dar forma para as classes Meta, Lembrete e Evento, que sao filhas de ItemAgenda
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
abstract public class ItemAgenda implements Serializable {
	// campos
	/**titulo do ItemAgenda*/
	private String titulo;
	/**descricao do Item*/
	private String descricao;
	/**faixa de tempo que o Item dura*/
	private Periodo p;

	/**Costrutor para inicializar valores nos campos titulo, descricao e p
	 * @param _titulo titulo do ItemAgenda*
	 * @param _descricao descricao do Item**
	 * @param _p Periodo que o Item dura*/
	public ItemAgenda(String _titulo, String _descricao, Periodo _p) {
		this.setTitulo(_titulo);
		this.setDescricao(_descricao);
		this.setP(_p);
	}

	// metodos get
	/** @return retornar campo privado: titulo*/
	public String getTitulo() {
		return this.titulo;
	}
	
	/** @return retornar campo privado: descricao*/
	public String getDescricao() {
		return this.descricao;
	}

	/** @return retornar campo privado: p*/
	public Periodo getP() {
		return this.p;
	}

	// metodos set
	/**metodo para alterar campo privado titulo
  	 * @param _titulo titulo do ItemAgenda*/
	public void setTitulo(String _titulo) {
		this.titulo = _titulo;
	}

	/**metodo para alterar campo privado descricao
  	 * @param _descricao descricao do ItemAgenda*/
	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}

	/**metodo para alterar campo privado p
  	 * @param _p Periodo do ItemAgenda*/
	public void setP(Periodo _p) {
		this.p = _p;
	}
	
	/**metodo sobrecarregado para alterar campo privado p
  	 * @param _dtInicio Data em que o periodo inicia*
	 * @param _hInicio Horario em que o periodo inicia*
	 * @param _dtFim Data em que o periodo finaliza*
	 * @param _hFim Horario em que o periodo finaliza*/
	public void setP(Data _dtInicio, Data _dtFim, Horario _hInicio, Horario _hFim) {
		Periodo _p = new Periodo(_dtInicio, _hInicio, _dtFim, _hFim);
		this.p = _p;
	}

	/**metodo sobrescrito para imprimir um objeto ItemAgenda ex: UFES- 'Passar em todas as matrias direto' (20/04/2001 - 11:44)  -  (15/05/2006 - 15:33)
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getTitulo());
		dados.append("-> '");
		dados.append(this.getDescricao());
		dados.append("' ");
		dados.append(this.getP());
		return dados.toString();
	}

}
