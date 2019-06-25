package ClassesDeAgendaPessoal;
import java.io.Serializable;
import java.util.Scanner;
/**
 * A classe: <b>Data</b> atende as definicoes de uma data contendo inteiros: dia, mes e ano. Possui: restricoes para gerar 
 * apenas objetos com data valida e metodos auxiliares para comparar os objetos  
 * <p>
 * Usada como objeto de periodo para compor uma variacao entre duas datas.
 * <p>
 * Implementa a interface Serializable, para permitir que as suas instâncias possam
 * ser usadas numa serialização (por exemplo, gravação em disco)
 *
 * @author Guilherme F. S.
 * @version 1.0 (Junho-2019)
 */

public class Data implements Serializable {
	/**Dia da data*/
	private int dia;
	/**Mes da data*/
	private int mes;
	/**Ano da data*/
	private int ano;

	
	/**Costrutores sobrecarregados para inicializar valores nos campos dia,mes e ano
	 * @throws Exception Data invalida
	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
  	 * 
	 * construtor mais generico: 3 inteiros */
	public Data(int _dia, int _mes, int _ano) throws Exception {
		this.setData(_dia, _mes, _ano);
	}

	public Data(int _dia, String _mes, int _ano) throws Exception {/** mes eh string */
		this.setData(_dia, _mes, _ano);
	}

	public Data(int _mes, int _ano) throws Exception {/** omite dia */
		this(1, _mes, _ano);
	}

	public Data(String Data) throws Exception {/** dd/mm/aaaa */
		this.setData(Data);
	}

	public Data() throws Exception {/** usuario digita*/
		this.digiteData();
	}

	/** @return retornar campos privados: dia*/
	public int getDia() {
		return this.dia;
	}
	/** @return retornar campos privados: mes*/
	public int getMes() {
		return this.mes;
	}
	/** @return retornar campos privados: ano*/
	public int getAno() {
		return this.ano;
	}

	/**metodos para alterar campos privados:  
	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
  	 * @throws Exception Data invalida*/
	public void setData(int _dia, int _mes, int _ano) throws Exception {
		if (isDataValida(_dia, _mes, _ano) == true) {// verificar Datas invalidas
			this.dia = _dia;
			this.mes = _mes;
			this.ano = _ano;
		} else // default
			throw new Exception("nota invalida");

	}

	/**metodo que altera objeto data, incrementando 1 dia
	 * @throws Exception Data invalida*/
	public void setIncrementaDia() throws Exception {
		this.setData(this.getDia() + 1, this.getMes(), this.getAno());
	}
	/**metodo que altera objeto data, incrementando 1 mes
	 * @throws Exception Data invalida*/
	public void setIncrementaMes() throws Exception {
		this.setData(this.getDia(), this.getMes() + 1, this.getAno());
	}
	/**metodo que altera objeto data, incrementando 1 ano
	 * @throws Exception Data invalida*/
	public void setIncrementaAno() throws Exception {
		this.setData(this.getDia(), this.getMes(), this.getAno() + 1);
	}

	/**metodo sobrecarregado que altera objeto data, incrementando n dias
	 * @param _dia quantidade de dias
	 * @throws Exception Data invalida*/
	public void setIncrementaDia(int _dia) throws Exception {
		while (_dia > 0) {
			this.setIncrementaDia();
			_dia--;
		}
	}

	/**metodo altera objeto Data digitando via teclado
	 * @throws Exception Data invalida*/
	public void digiteData() throws Exception {
		System.out.println("Digite dia:");
		Scanner scan = new Scanner(System.in);
		int _dia = scan.nextInt();
		System.out.println("Digite mes:");
		Scanner scan2 = new Scanner(System.in);
		int _mes = scan2.nextInt();
		System.out.println("Digite ano:");
		Scanner scan3 = new Scanner(System.in);
		int _ano = scan3.nextInt();
		this.setData(_dia, _mes, _ano);
	}

	/**metodo para alterar valor quando mes eh String
	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
  	 * @throws Exception Data invalida
  	 */
	public void setData(int _dia, String _mes, int _ano) throws Exception {
		int i = 0;
		if (_mes.equals("janeiro"))
			i = 1;
		else if (_mes.equals("fevereiro"))
			i = 2;
		else if (_mes.equals("marco"))
			i = 3;
		else if (_mes.equals("abril"))
			i = 4;
		else if (_mes.equals("maio"))
			i = 5;
		else if (_mes.equals("junho"))
			i = 6;
		else if (_mes.equals("julho"))
			i = 7;
		else if (_mes.equals("agosto"))
			i = 8;
		else if (_mes.equals("setembro"))
			i = 9;
		else if (_mes.equals("outubro"))
			i = 10;
		else if (_mes.equals("novembro"))
			i = 11;
		else if (_mes.equals("dezembro"))
			i = 12;
		setData(_dia, i, _ano);
	}

	/**metodo para alterar valor quando dia/mes/ano eh String 
	 * @param _data representa a data, exemplo: setData(dd,mm,aaaa)
	 * @throws Exception Data invalida*/
	public void setData(String _data) throws Exception {
		int auxDia, auxMes, auxAno, i, j;
		i = _data.indexOf("/");
		j = _data.indexOf("/", i + 1);
		auxDia = Integer.parseInt(_data.substring(0, i));
		auxMes = Integer.parseInt(_data.substring(i + 1, j));
		auxAno = Integer.parseInt(_data.substring(j + 1));
		this.setData(auxDia, auxMes, auxAno);
	}

	/**metodo estatico que verifica se a data e valida
	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
  	 * @return boolean*/
	private static boolean isDataValida(int _dia, int _mes, int _ano) {
		if (_dia < 1 || _mes < 1 || _mes > 12)
			return false;
		else if ((_mes == 4 || _mes == 6 || _mes == 9 || _mes == 11) && _dia > 30)
			return false;
		else if ((_mes == 1 || _mes == 3 || _mes == 5 || _mes == 7 || _mes == 8 || _mes == 10 || _mes == 12)
				&& (_dia > 31))
			return false;
		else if (_ano < 1582)
			return false;
		else if (_mes == 2 && isBissexto(_ano) && _dia > 29)
			return false;
		else if (_mes == 2 && !isBissexto(_ano) && _dia > 28)
			return false;
		else
			return true;
	}
	/**metodo sobrecarregado que verifica se a data e valida, relativo ao objeto que faz a chamada
	 * @return boolean*/
	private boolean isDataValida() {
		if (this.dia < 1 || this.mes < 1 || this.mes > 12)
			return false;
		else if ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && this.dia > 30)
			return false;
		else if ((this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10
				|| this.mes == 12) && (this.dia > 31))
			return false;
		else if (this.ano < 1582)
			return false;
		else if (this.mes == 2 && isBissexto(this.ano) == true && this.dia > 29)
			return false;
		else if (this.mes == 2 && isBissexto(this.ano) == false && this.dia > 28)
			return false;
		else
			return true;
	}

	/**metodo que verifica se o ano e bissexto
  	 * @param _ano ano da Data
  	 * @return boolean */
	private static boolean isBissexto(int _ano) {
		if ((_ano % 4 == 0 && _ano % 100 != 0) || (_ano % 400 == 0))
			return true;
		else
			return false;
	}
	
	/**metodo sobrecarregado que verifica se o ano e bissexto, relativo ao objeto que faz a chamada
	 * @return boolean*/
	private boolean isBissexto() {
		if ((this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0))
			return true;
		else
			return false;
	}
	/**ultiliza metodo isDataValida(int _dia, int _mes, int _ano) declarado nessa classe. Cria uma Data, se for valida
	 * @param _dia dia da Data
  	 * @param _mes mes da Data
  	 * @param _ano ano da Data
	 * @throws Exception Data invalida
	 * @return Data*/
	public static Data verificaECriaData(int _dia, int _mes, int _ano) throws Exception {
		if (isDataValida(_dia, _mes, _ano) == true) {
			Data x = new Data(_dia, _mes, _ano);
			return x;
		} else
			return null;
	}
	/**metodo sobrescrito  para comparar 2 objetos Data
	 * @param  dt objeto Data
	 * @return 1 ou 0 ou -1*/
	public int compareTo(Data dt) {
		if (this.ano > dt.ano)
			return 1;
		else if (this.ano < dt.ano)
			return -1;
		else if (this.ano == dt.ano && this.mes > dt.mes)
			return 1;
		else if (this.ano == dt.ano && this.mes < dt.mes)
			return -1;
		else if (this.ano == dt.ano && this.mes == dt.mes && this.dia > dt.dia)
			return 1;
		else if (this.ano == dt.ano && this.mes == dt.mes && this.dia < dt.dia)
			return -1;
		else
			return 0;
	}
	
	/**metodo sobrescrito para imprimir objeto Data ex: 20/06/2019
	 * @return toString*/
	public String toString() {
		StringBuilder dados = new StringBuilder();
		if (this.getDia() < 10)
			dados.append("0");
		dados.append(this.getDia());
		dados.append("/");
		if (this.getMes() < 10)
			dados.append("0");
		dados.append(this.getMes());
		dados.append("/");
		if (this.getAno() < 10)
			dados.append("0");
		dados.append(this.getAno());
		return dados.toString();
	}
	
	 /**metodo sobrescrito  para comparar se 2 objetos Data sao iguais ou diferentes
	 * @param objeto Data
	 * @return boolean*/
	public boolean equals(Object objeto) {
		Data aux = (Data) objeto;
		if (this.getDia() == aux.getDia() && this.getMes() == aux.getMes() && this.getAno() == aux.getAno())
			return true;
		return false;
	}
}