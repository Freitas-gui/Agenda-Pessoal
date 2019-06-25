package ClassesDeAgendaPessoal;
import java.io.Serializable;
/**
 * A classe: <b>Periodo</b> possui variacao entre duas Datas e Dois horarios
 * <p>
 * Usada como objeto de Item de Agenda para compor uma faixa de tempo.
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
public class Periodo implements Serializable {
	// campos
	/**Data em que o periodo inicia*/
	private Data dtInicio;
	/**Data em que o periodo finaliza*/
	private Data  dtFim;
	/**Horario em que o periodo inicia*/
	private Horario hInicio;
	/**Horario em que o periodo finaliza*/
	private Horario hFim;

	/**Costrutor para inicializar valores nos campos dtInicio, dtFim, hInicio e hFim
	 * @param _dtInicio Data em que o periodo inicia*
	 * @param _hInicio Horario em que o periodo inicia*
	 * @param _dtFim Data em que o periodo finaliza*
	 * @param _hFim Horario em que o periodo finaliza*/
	public Periodo(Data _dtInicio, Horario _hInicio, Data _dtFim, Horario _hFim) {
		this.setDtInicio(_dtInicio);
		this.sethInicio(_hInicio);
		this.setDtFim(_dtFim);
		this.sethFim(_hFim);
	}
	
	/**Costrutor sobrecarregado para inicializar valores nos campos dtInicio, dtFim, hInicio e hFim. Sem precisar criar objetos Data e Horario previamente
	 * @param diaInicio dia inicial do Periodo
  	 * @param mesInicio mes inicial do Periodo
  	 * @param anoInicio ano inicial do Periodo
  	 * @param horaIni hora inicial em um Periodo
	 * @param minutoIni minuto inicial em um Periodo
	 * @param diaFim dia final do Periodo
  	 * @param mesFim mes final do Periodo
  	 * @param anoFim ano final do Periodo
  	 * @param horaFim hora final em um Periodo
	 * @param minutoFim minuto final em um Periodo
	 * @throws Exception periodo invalido*/
	public Periodo(int diaInicio, int mesInicio, int anoInicio, int horaIni, int minutoIni, int diaFim, int mesFim,
			int anoFim, int horaFim, int minutoFim) throws Exception {
		this.setDtInicio(diaInicio, mesInicio, anoInicio);
		this.sethInicio(horaIni, minutoIni);
		this.setDtFim(diaFim, mesFim, anoFim);
		this.sethFim(horaFim, minutoFim);
	}

	/** @return retornar campo privado: dtInicio*/
	public Data getDtInicio() {
		return this.dtInicio;
	}
	/** @return retornar campo privado: dtFim*/
	public Data getDtFim() {
		return this.dtFim;
	}
	/** @return retornar campo privado: hInicio*/
	public Horario gethInicio() {
		return this.hInicio;
	}
	/** @return retornar campo privado: hFim*/
	public Horario gethFim() {
		return this.hFim;
	}

	/**metodo para alterar campo privado dtInicio, ultiliza construtor da classe Data
  	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
  	 * @throws Exception Data invalido*/
	public void setDtInicio(int _dia, int _mes, int _ano) throws Exception {
		Data _dtInicio = new Data(_dia, _mes, _ano);
		this.dtInicio = _dtInicio;
	}
	
	/**metodo para alterar campo privado dtInicio, ultiliza Data criada previamente e passado como argumento
	 * @param _dtInicio Data inicial do Periodo*/
	public void setDtInicio(Data _dtInicio) {
		this.dtInicio = _dtInicio;
	}
	
	/**metodo para alterar campo privado dtFim, ultiliza construtor da classe Data
  	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
  	 * @throws Exception Data invalida*/
	public void setDtFim(int _dia, int _mes, int _ano) throws Exception {
		Data _dtFim = new Data(_dia, _mes, _ano);
		this.dtFim = _dtFim;
	}
	
	/**metodo para alterar campo privado dtFim, ultiliza Data criada previamente e passado como argumento
	 * @param _dtFim Data final do Periodo*/
	public void setDtFim(Data _dtFim) {
		this.dtFim = _dtFim;
	}
	
	/**metodo para alterar campo privado hInicio, ultiliza construtor da classe Horario
	 * @param _hora quantidade de hora em um horario
	 * @param _minuto quantidade de minuto em um horario
	 * @throws Exception Horario invalido */ 
	public void sethInicio(int _hora, int _minuto) throws Exception {
		Horario hInicio = new Horario(_hora, _minuto);
		this.hInicio = hInicio;
	}
	
	/**metodo para alterar campo privado hInicio, ultiliza Horario criado previamente e passado como argumento
	 * @param _hInicio Horario inicial do Periodo*/
	public void sethInicio(Horario _hInicio) {
		this.hInicio = _hInicio;
	}

	/**metodo para alterar campo privado hFim, ultiliza construtor da classe Horario
	 * @param _hora quantidade de hora em um horario
	 * @param _minuto quantidade de minuto em um horario
	 * @throws Exception Horario invalido */ 
	public void sethFim(int _hora, int _minuto) throws Exception {
		Horario hFim = new Horario(_hora, _minuto);
		this.hFim = hFim;
	}

	/**metodo para alterar campo privado hFim, ultiliza Horario criado previamente e passado como argumento
	 * @param _hFim Horario final do Periodo*/
	public void sethFim(Horario _hFim) {
		this.hFim = _hFim;
	}

	/**metodo sobrescrito para imprimir um objeto Periodo ex: (20/04/2007 - 11:44) - (15/05/2010 - 15:33)
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("(");
		dados.append(this.getDtInicio());
		dados.append(" - ");
		dados.append(this.gethInicio());
		dados.append(") ");
		dados.append(" -> ");
		dados.append(" (");
		dados.append(this.getDtFim());
		dados.append(" - ");
		dados.append(this.gethFim());
		dados.append(") ");
		return dados.toString();
	}
}
