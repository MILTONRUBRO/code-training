package br.com.devmos.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UtilNumbers {
	
	public static int numeroAleatorio(int min, int max) {
		return new Random().ints(min, max + 1).findFirst().getAsInt();
	}
	
	public static String geraSenhaNumerica(int tamanho) {
		StringBuilder sb = new StringBuilder();
		new Random().ints(0, 10).limit(tamanho).forEach(n -> sb.append(n));
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
	
	public static String geraPlacaVeiculo() {
		StringBuilder sb = new StringBuilder();
		sb.append(geraSenhaLetras(3)).append("-").append(geraSenhaNumerica(4));		
		return sb.toString();
	}
	
	public static String geraCEP() {
		var sb = new StringBuilder();
		new Random().ints(0, 10).limit(8).forEach( n -> sb.append(n));
		sb.insert(5, "-");
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
	
	
	public static int maxSubArraySum(int[] numbers) {
		var maxSum = numbers[0];
		var sum = numbers[0];
		
		for(var i = 1; i < numbers.length; i++) {
			var number = numbers[i];
			sum = Math.max(sum + number, number);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}
	
	public static boolean isPrime(int number) {
		if(number <= 1)
			return false;
		else if(number == 2)
			return true;
		else if(number % 2 == 0)
			return false;
		
		for(int i = 3; i <= Math.sqrt(number); i += 2) {
			if(number % i == 0)
				return false;
		}
		return true;
	}
	
	public static Double getPotencia(Double num1, Double num2) {
		return Math.pow(num1, num2);
	}
	
	public static long factorial(int num) {
		if( num <= 1)
			return 1;
		
		return factorial(num - 1) * num;
	}
	
	public static void minAndMax(List<Integer> numbers) {
		numbers.sort(Comparator.comparing(Integer::intValue));
		int sumMax = numbers.stream().mapToInt(i -> i).sum() - numbers.get(0);
		int sumMin = numbers.stream().mapToInt(i -> i).sum() - numbers.get(numbers.size()-1);

		System.out.println("Max: " + sumMax);
		System.out.println("Min: " + sumMin);

	}
	
	public static List<Integer> removeAllNegativeNumbers(List<Integer> numbers) {
		 return numbers.stream().filter(n -> n > 0).collect(Collectors.toList());
	}
	
	public static List<Integer> removeAllOddNumbers(List<Integer> numbers){
		return numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
	}
	
	public static Integer token() {
		StringBuilder sb = new StringBuilder();
		new Random().ints(0, 10).limit(6)
								.forEach( n -> sb.append(n));
	
		return Integer.valueOf(sb.toString());
	}
	
	public static String getMegaSena() {
		var sb = new StringBuilder();
		
		new Random().ints(1, 61).limit(6).forEach(n -> sb.append(n).append(" "));
		
		return sb.toString();
	}
	
	public static String generateAuthenticator() {
		var sb = new StringBuilder();
		
		new Random().ints(0, 10).limit(6).forEach(n -> sb.append(n));
		
		return sb.toString();
	}
	
	public static Integer candles(List<Integer> candles) {
		return (int) candles.stream().filter(n -> n.equals(Collections.max(candles))).count();
	}
	
	public static int diagonalDifference(List<List<Integer>> arr) {
		int leftSum = 0;
		int rightSum = 0;
		
		for(int row = 0, col = 0; row < arr.size(); row++, col++) {
			leftSum = leftSum + arr.get(row).get(row);
			rightSum = rightSum + arr.get(row).get(arr.size() - 1 - row);
		}
		
		return Math.abs(leftSum - rightSum);
	}
	
    public static int binaryToInt(String str) {
    	return Integer.parseInt(str, 2);
    }
}

