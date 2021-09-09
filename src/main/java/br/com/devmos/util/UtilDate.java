package br.com.devmos.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UtilDate {
	
	public static LocalDate stringToDate(String data) {
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("d-MM-yyyy"));
	}
	
	public static LocalDate stringToDate(String data, DateTimeFormatter formatter) {
		return LocalDate.parse(data, formatter);
	}
	
	public static LocalTime stringToTime(String time) {
		return LocalTime.parse(time);
	}
	
	public static Period calculateAge(LocalDate date) {
		return Period.between(date, LocalDate.now());
	}
}
