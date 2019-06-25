package ClassesDeAgendaPessoal;
import java.io.Serializable;
/**
 * A classe: <b>Horario</b> atende as definicoes de um horario contendo inteiros: hora e minuto. Possui: restricoes para gerar 
 * apenas objetos com horario valido 
 * <p>
 * Usado como objeto de periodo para compor uma variacao entre dois horarios.
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */
public class Horario implements Serializable {
	// campos
	/**quantidade de hora em um horario*/
	private int hora;
	/**quantidade de minuto em um horario*/
	private int minuto;

	/**Costrutor para inicializar valores nos campos hora e minuto
	 * @throws Exception harario invalido
	 * @param _hora quantidade de hora em um horario*
	 * @param _minuto quantidade de minuto em um horario*/
	// construtores
	public Horario(int _hora, int _minuto) throws Exception {
		this.setHora(_hora);
		this.setMinuto(_minuto);
	}
	/**Costrutor sobrecarregado (default) para inicializar valores nos campos hora=0 e minuto=0
	 * @throws Exception harario invalido*/
	public Horario() throws Exception {
		this(0, 0);
	}

	// metodos de interface get e set
	/** @return retornar campo privado: hora*/
	public int getHora() {
		return this.hora;
	}
	/** @return retornar campo privado: minuto*/
	public int getMinuto() {
		return this.minuto;
	}
	
	/**metodo para alterar campo privado hora:  
  	 * @param _hora hora de horario
  	 * @throws Exception Horario invalido*/
	public void setHora(int _hora) throws Exception {
		if (_hora >= 0 && _hora <= 23)
			this.hora = _hora;
		else
			throw new Exception("Hora invalida");
	}
	 /**metodo para alterar campo privado minuto:  
  	 * @param _minuto minuto de minuto
  	 * @throws Exception Horario invalido*/
	public void setMinuto(int _minuto) throws Exception {
		if (_minuto >= 0 && _minuto <= 59)
			this.minuto = _minuto;
		else
			throw new Exception("Minuto invalido");
	}

	/**metodo sobrescrito para imprimir objeto Horario ex: 20:25
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		if (this.getHora() < 10)
			dados.append("0");
		dados.append(this.getHora());
		dados.append(":");
		if (this.getMinuto() < 10)
			dados.append("0");
		dados.append(this.getMinuto());
		return dados.toString();
	}

}
