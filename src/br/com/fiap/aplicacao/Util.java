package br.com.fiap.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date stringToDate(String data)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
