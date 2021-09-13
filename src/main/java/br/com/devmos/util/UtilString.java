package br.com.devmos.util;

import java.util.regex.Pattern;

public class UtilString {

	public static boolean containsOnlyDigits(String str) {
		return !str.chars().anyMatch(n -> !Character.isDigit(n));
	}
	
	public static String removeCharacter(String str, char ch) {
		return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
	}
}
