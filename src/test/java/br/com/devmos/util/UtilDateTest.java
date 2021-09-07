package br.com.devmos.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import org.junit.Test;

public class UtilDateTest {

	private static final String STRING_DATE = "06-09-2021";
	private static final String STRING_DATE_ISO = "2021-09-06";

	@Test
	public void testStringToDateOk() {
		LocalDate date = UtilDate.stringToDate(STRING_DATE);

		assertEquals(6, date.getDayOfMonth());
		assertEquals(9, date.getMonth().getValue());
		assertEquals(2021, date.getYear());
	}
	
	@Test
	public void testStringToDateWithFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		LocalDate date = UtilDate.stringToDate(STRING_DATE_ISO, formatter);

		assertEquals(6, date.getDayOfMonth());
		assertEquals(9, date.getMonth().getValue());
		assertEquals(2021, date.getYear());
	}
}
