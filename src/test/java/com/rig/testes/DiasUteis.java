package com.rig.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DiasUteis {
	public static void main(String[] args) {
		/*
		 * int diaDeSemana; Date data = new Date(); diaDeSemana = data.getDay();
		 * for (int i = 0; i <= 31; i++) { if (diaDeSemana == 0 | diaDeSemana ==
		 * 6) { System.out.println(diaDeSemana + " final de semana."); } else {
		 * System.out.println(diaDeSemana + " dia util."); } }
		 */
	}

	public static int deductDates(Date initialDate, Date finalDate) {
		if (initialDate == null || finalDate == null) {
			return 0;
		}
		int days = (int) ((finalDate.getTime() - initialDate.getTime()) / (24 * 60 * 60 * 1000));
		return days;
	}

	public static Date stringToDate(String stringDate) throws ParseException {
		Date data = null;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", new Locale(
				"pt_BR"));
		data = df.parse(stringDate);
		return data;
	}
	
	

}
