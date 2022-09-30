package br.com.devmos.util;

public class CrackingCodeInterviewUtil {
	
	/**
	 * time complexity O(n)
	 * @param words
	 * @return string
	 */
	public static String joinWords(String[] words) {
		StringBuilder sb = new StringBuilder();
		
		for(String word : words) {
			sb.append(word);
		}
		return sb.toString();
	}

}
