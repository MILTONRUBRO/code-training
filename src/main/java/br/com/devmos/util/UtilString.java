package br.com.devmos.util;

public class UtilString {

	public static boolean containsOnlyDigits(String str) {
		return !str.chars().anyMatch(n -> !Character.isDigit(n));
	}
}
