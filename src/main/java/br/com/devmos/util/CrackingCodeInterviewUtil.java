package br.com.devmos.util;

public class CrackingCodeInterviewUtil {
	
	/**
	 * O(n)
	 * @param words
	 * @return
	 */
	public static String joinWords(String[] words) {
		StringBuilder sb = new StringBuilder();
		
		for(String word : words) {
			sb.append(word);
		}
		return sb.toString();
	}

}
