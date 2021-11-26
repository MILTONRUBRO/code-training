package br.com.devmos.util;

import java.util.ArrayList;

public class HashUtil {
	private static final int HASH = 7;
	private static final int FACTOR = 37;
	private static final String LETTERS = "abcdegilmnoprstuw";
	
	public static long getHash(String str) {
		long hash = HASH;
		int size = str.length();
		
		for(int i = 0; i < size; i++) {
			 hash = hash * FACTOR + LETTERS.indexOf(str.charAt(i));
		}
		return hash;
	}
	
	public static String desHash(long hashed) {
		var numeros = new ArrayList<Long>();
		
		for(int i = 0; i < HASH; i++) {
			numeros.add(hashed);
			hashed = hashed/FACTOR;
		}
		
		var sb = new StringBuilder();
		char c;
		long number;
		
		for(int i = HASH-1; i >= 0; i-- ) {
			
			if( i == 6) {
				number = numeros.get(i) - (HASH * FACTOR);
				c = LETTERS.charAt((int) number);
				sb.append(c);
			}else {
				number = numeros.get(i) - (numeros.get(i+1) * FACTOR);
				c = LETTERS.charAt((int) number);
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
