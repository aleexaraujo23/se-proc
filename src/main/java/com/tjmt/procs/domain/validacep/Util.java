package com.tjmt.procs.domain.validacep;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.internal.util.config.ConfigurationHelper;

import com.tjmt.procs.domain.model.Tb_endereco_parte;

public class Util {

	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
	public static final String DATE_FORMAT_DEFAULT = "%tY";

	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%05d";

	public static final String DATE_NUMBER_SEPARATOR_PARAMETER = "dateNumberSeparator";
	public static final String DATE_NUMBER_SEPARATOR_DEFAULT = "0";

	private String format;

	// compare enderecos
	public static boolean verifcaEnds(Tb_endereco_parte end_parte, Endereco end_cep) {

		if (!end_parte.getCidade().equals(end_cep.getLocalidade()) || !end_parte.getEstado().equals(end_cep.getUf())) {
			return false;

		} else {

			return true;
		}

	}

	// gera numero processo
	public static String geraNrProcesso(Long long1) {
		String nr = "";
    	
    	Calendar calendar = Calendar.getInstance();//cria o obj calendar e atribui a hora e data do sistema
    	Date data = calendar.getTime();//transforma o obj calendar em obj Date
    	SimpleDateFormat sddia = new SimpleDateFormat("MM.yyyy");//cria um obj de formatação de data
    	String mes_ano = sddia.format(data);//gera a string final formatada no estilo "dd-MM-yyyy"

    	DecimalFormat df = new DecimalFormat("0000000");

    	String id = df.format(long1);
		
		nr = id + "-"+ mes_ano +".801" ;
		
		return nr;
	}
}
