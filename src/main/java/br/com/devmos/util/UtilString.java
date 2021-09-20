package br.com.devmos.util;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UtilString {

	public static boolean containsOnlyDigits(String str) {
		return !str.chars().anyMatch(n -> !Character.isDigit(n));
	}
	
	public static String removeCharacter(String str, char ch) {
		return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
	}
	
	public static List<String> ordenaPeloTamanho(List<String> strs){
		return strs.stream()
		.sorted(Comparator.comparingInt(String::length))
		.collect(Collectors.toList());
	}
}
