package br.com.devmos.util;

import java.util.Random;

public class UtilNumbers {
	
	public static int numeroAleatorio(int min, int max) {
		var random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public static String geraSenhaNumerica(int tamanho) {
		var random = new Random();
		StringBuilder sb = new StringBuilder();
		for(var i = 0; i < tamanho; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
	public static String geraSenhaLetras(int tamanho) {
		var random = new Random();
		StringBuilder sb = new StringBuilder();
		for(var i = 0; i < tamanho; i++) {
			sb.append((char) (random.nextInt(26) + 'a'));
		}
		return sb.toString();
	}
}
