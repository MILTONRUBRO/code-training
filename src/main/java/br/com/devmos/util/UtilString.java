package br.com.devmos.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
	
	public static Set<String> removeRepeated(List<String> strs){
		return new HashSet<>(strs);
	}
	
	public static List<String> ordena(List<String> strs){
		return strs.stream()
					.sorted(Comparator.naturalOrder())
					.collect(Collectors.toList());
	}
	
	public static int letraAlfabetoParaNumerico(Character c) {
		int numericValue = c;
		return numericValue - 64;
	}
	
	public static boolean isStringOnlyAlphabet(String str) {
		return ((!str.equals("")) 
				&&(str != null)
				&& (str.chars().allMatch(Character::isLetter)));
	}
	
	public static String reverterOrdemString(String str) {
		int tam = str.split(" ").length;
		StringBuilder sb = new StringBuilder();
		
		for(int i = tam-1; i >= 0; i--) {
			String[] strSplited = str.split(" ");
			sb.append(strSplited[i] + " ");
		}
		return sb.toString().trim();
	}
	
	public static String removeNonAlphabetChar(String str) {
		String[] tokens = str.split("\\W+");
		StringBuilder sb = new StringBuilder();
		for(String token : tokens) {
			sb.append(token + " ");
		}
		
		return sb.toString().trim();
	}
	
	
	public static String getRandomNameFromList(List<String> names) {
		Random random = new Random();
		int number = random.nextInt(names.size());
		return names.get(number);
	}
	
	public static String joinByDelimiter(char delimiter, String...  args) {
		return Arrays.stream(args, 0, args.length)
						.collect(Collectors.joining(String.valueOf(delimiter)));
	}
}
