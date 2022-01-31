package br.com.devmos.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		int number = new Random().nextInt(names.size());
		return names.get(number);
	}
	
	public static String joinByDelimiter(char delimiter, String...  args) {
		return Arrays.stream(args, 0, args.length)
						.collect(Collectors.joining(String.valueOf(delimiter)));
	}
	
	public static boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	public static String removeComentsHtml(String str) {
		return str.replaceAll("(?s)<!--.*?-->", "");
	}
	
	public static String repeatStringWithSpace(String str, int tam) {
		 return str.repeat(tam);
	}
	
	public static int countVowels(String str) {
		int count  = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(isVowel(str.charAt(i))) {
				++count;
			}
		}
		return count;
	}

	private static boolean isVowel(char ch) {
		ch = Character.toUpperCase(ch);		
		return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
	}
	
	public static Character  findDuplicate(String str) {
		Map<Character, Integer> values = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			char letra = str.charAt(i);
			
			if(values.containsKey(letra)) {
				return letra;
			}
			
			values.put(letra, i);
		}
		return null;
	}
	
    static String encryptString(String s, int k) {
        int countVowels = 0;
        int countConsonants = 0;
        var  ans = new StringBuilder();
        int size = s.length();
 
        for (int i = 0; i <= size - k; i++) {
            countVowels = 0;
            countConsonants = 0;
 
            for (int r = i; r <= i + k - 1; r++) {
                if (isVowel(s.charAt(r))) {
                    countVowels++;
                } else {
                    countConsonants++;
                }
            }
 
            ans.append(String.valueOf(countVowels * countConsonants));
        }
        return ans.toString();
    }
    
    public static boolean isCommonSubstring(String s1, String s2) {
    	char[] chars = s1.toCharArray();
    	
    	Set<Character> charSet = new HashSet<Character>();
    	
    	for(char c : chars) {
    		charSet.add(c);
    	}
    	
    	for(int i = 0; i < s2.length(); i++) {
    		if(charSet.contains(s2.charAt(i)))
    			return true;
    	}
    	return false;
    	
    }

}
