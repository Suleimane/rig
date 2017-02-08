package com.rig.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class Datas {
	public static void main(String[] args) {
		/*
		 * Date data = new Date(); int ano = data.getYear(); int dia =
		 * data.getDate(); System.out.println(ano + 1900);
		 * System.out.println(dia);
		 */

		/*
		 * Calendar calendario = Calendar.getInstance(); int ano =
		 * calendario.get(Calendar.YEAR); int mes =
		 * calendario.get(Calendar.MONTH); int dia =
		 * calendario.get(Calendar.DAY_OF_MONTH);
		 * 
		 * int mesAtual = mes + 1;
		 * 
		 * System.out.println(dia + "/" + mesAtual + "/" + ano);
		 */

		/*
		 * String data1 = "01/07/2016"; String data2 = "31/07/2016";
		 * 
		 * System.out.println(getWorkingDays(stringToDate(data1),
		 * stringToDate(data2)));
		 * 
		 * int diasInteiro = (int) getWorkingDays(stringToDate(data1),
		 * stringToDate(data2));
		 * 
		 * for (int i = 1; i <= diasInteiro; i++) { System.out.println(i); }
		 * 
		 * int ultimoDia = ultimoDiaMesAtual(); System.out.println(ultimoDia);
		 */
		/*
		 * 
		 * imprimeDias(stringToDate(data1), stringToDate(data2));
		 */
		/*
		 * String data1 = "01/07/2016", data2 = "31/07/2016";
		 * imprimeDias(stringToDate(data1), stringToDate(data2));
		 */

		String data1 = "01/02/2016", data2 = "29/02/2016";
		/*
		 * ArrayList<Integer> dias = new ArrayList<Integer>(); dias =
		 * (ArrayList<Integer>) listarDias(stringToDate(data1),
		 * stringToDate(data2)); for (int i = 1; i <= dias.size() - 1; i++) {
		 * System.out.println(dias.get(i)); }
		 */
		/*
		 * for (int dia : listarDias(stringToDate(data1), stringToDate(data2)))
		 * { System.out.println(dia); }
		 */

		/*
		 * for (String mes : listarMeses()) { System.out.println(mes); }
		 */
		for (int dia : diasUteis()) {
			System.out.println(dia);
		}

	}

	public static Date stringToDate(String stringDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
					new Locale("pt_BR"));
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static int deductDates(Date initialDate, Date finalDate) {
		if (initialDate == null || finalDate == null) {
			return 0;
		}
		int days = (int) ((finalDate.getTime() - initialDate.getTime()) / (24 * 60 * 60 * 1000));
		return (days > 0 ? days : 0);
	}

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale(
				"pt_BR"));
		String dateFormated = sdf.format(date);
		return dateFormated;
	}

	public static Date clearHour(Date date) {
		return (stringToDate(dateToString(date)));
	}

	public static double getWorkingDays(Date initialDate, Date finalDate) {
		double workingDays = 0;
		double incremento = 0;
		int totalDays = deductDates(initialDate, finalDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(initialDate);
		for (int i = 0; i <= totalDays; i++) {
			if (!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
					incremento = 0.5;
				} else {
					incremento = 1;
				}
				workingDays = workingDays + incremento;
			}

			calendar.add(Calendar.DATE, 1);
		}
		return workingDays;
	}

	public static List<Integer> listarDias(Date dataInicial, Date dataFinal) {
		int ultimoDia = deductDates(dataInicial, dataFinal);
		ArrayList<Integer> diasUteis = new ArrayList<Integer>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dataInicial);
		for (int i = 1; i <= ultimoDia + 1; i++) {
			if (!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				int dia = calendar.get(Calendar.DAY_OF_MONTH);
				diasUteis.add(dia);
			}
			calendar.add(Calendar.DATE, 1);
		}
		return diasUteis;
	}

	public static List<Integer> diasUteis() {
		int ultimoDia = ultimoDiaMesAtual();
		ArrayList<Integer> dias = new ArrayList<Integer>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(calendar.getInstance().getTime());
		for (int i = 1; i <= ultimoDia + 1; i++) {
			if (!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				int dia = calendar.get(Calendar.DAY_OF_MONTH);
				dias.add(dia);
			}
			calendar.add(Calendar.DATE, 1);
		}
		return dias;
	}

	public static List<String> listarMeses() {
		ArrayList<String> meses = new ArrayList<String>();
		meses.add("JAN");
		meses.add("FEV");
		meses.add("MAR");
		meses.add("ABR");
		meses.add("MAI");
		meses.add("JUN");
		meses.add("JUL");
		meses.add("AGO");
		meses.add("SET");
		meses.add("OUT");
		meses.add("NOV");
		meses.add("DEZ");
		return meses;
	}

	public static int ultimoDiaMesAtual() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDay;
	}

	public static void primeiroDia() {
		Calendar calendar = Calendar.getInstance();
		calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(calendar);
	}

}
