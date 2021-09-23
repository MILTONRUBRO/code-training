package br.com.devmos.util;

import java.util.Comparator;
import java.util.List;
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
	
	public static int getMinNumber(List<Integer> numbers) {
		return numbers.stream().min(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);
	}
	
	public static int getMaxNumber(List<Integer> numbers) {
		return numbers.stream().max(Comparator.naturalOrder()).orElse(Integer.MAX_VALUE);
	}
	
	public static double getAverage(List<Integer> numbers) {
		return numbers.stream().mapToInt(i -> i).average().getAsDouble();
	}
	
	public static int getSum(List<Integer> numbers) {
		return numbers.stream().mapToInt(i -> i).sum();
	}
}
