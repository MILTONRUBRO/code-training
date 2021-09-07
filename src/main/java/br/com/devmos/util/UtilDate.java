package br.com.devmos.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilDate {
	
	public static LocalDate stringToDate(String data) {
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("d-MM-yyyy"));
	}
	
	public static LocalDate stringToDate(String data, DateTimeFormatter formatter) {
		return LocalDate.parse(data, formatter);
	}


}
