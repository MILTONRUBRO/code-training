package br.com.devmos.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
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
    
    public static Set<String> permuteAndStore(String prefix, String str){
    	Set<String> permutations = new HashSet<>();
    	int size = str.length();
    	
    	if(size == 0) {
    		permutations.add(prefix);
    	}else {
    		for(int i = 0; i < size; i++) {
    			permutations.addAll(permuteAndStore(prefix + str.charAt(i), str.substring(i + 1, size) + str.substring(0, i)));
    		}
    	}
    	return permutations;
    }
    
    public static String getSecurePasword(String password, String salt) throws NoSuchAlgorithmException {
    	MessageDigest md = MessageDigest.getInstance("SHA-512");
    	
    	md.update(salt.getBytes(StandardCharsets.UTF_8));
    	byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
    	var sb = new StringBuilder();
    	for(int i = 0; i < bytes.length; i++) {
    		sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16 ).substring(1));
    	}
    	return sb.toString();
    }
    
    public static int countStringInString(String str, String toFind) {
    	int result = str.split(Pattern.quote(toFind), -1).length - 1;
    	return result < 0 ? 0 : result;
    }
    
    public static String revert(String str) {
    	return new StringBuilder(str).reverse().toString();
    }
    
    public static List<String> getNamesWithDeterminateLetter(String letter, List<String> names) {
    	return names.stream()
    				.filter(name -> name.startsWith(letter))
    				.collect(Collectors.toList());
    }
    
    public static List<String> filterListWithCollectionOfPredicatesUsingAnd(List<String> names){
        List<Predicate<String>> allPredicates = new ArrayList<>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));        
        allPredicates.add(str -> str.length() > 4);
        
        return names.stream()
        			.filter(allPredicates.stream().reduce(x -> true, Predicate::and))
        			.collect(Collectors.toList());
    }
    
    public static String commonChildString(String str1, String str2) {
    	var sb = new StringBuilder();
    	for(int i = 0; i < str1.length(); i++) {
    		char c = str1.charAt(i);
    		if(str2.contains(String.valueOf(c))) {
    			sb.append(c);
    		}
    	}
    	return sb.toString();
    }
    
    public static List<String> listWithoutBlank(List<String> list) {
    	return  list.stream()
    			  .filter(Predicate.not(String::isBlank))
    			  .collect(Collectors.toList());
    }
    
    public static String[] simpleListToArray(List<String> list) {
    	return list.toArray(String[]::new);
    }

}
