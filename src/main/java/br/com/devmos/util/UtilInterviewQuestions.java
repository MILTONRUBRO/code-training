package br.com.devmos.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class UtilInterviewQuestions {
	
	/**
	 * Dado um array de inteiros
	 * retorne o indice dos dois elementos que a soma seja igual ao target
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			
			if(map.containsKey(temp)) {
				int[] x = new int[2];
				x[0] = map.get(temp);
				x[1] = i;
				return x;
			}
			
			map.put(nums[i], i);
		}
		return nums;
	}
	
	/**
	 * Dado um array de inteiros representado valor de a��es
	 * deve se encontrar qual o melhor valor para se vender
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] <= min)
				min = prices[i];
			if(prices[i] - min >= max)
				max = prices[i] - min;
		}
		return max;
	}
	
	/**
	 * Dado uma string com paranteses, chaves e colchetes
	 * return se � valido com a abertura e fechamento do mesmo tipo
	 * @return
	 */
	public static boolean isValid(String str) {
		Map<Character, Character> map = new HashMap<>();
		
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		
		Stack<Character> answer = new Stack<>();
		
		for(int i = 0; i < str.length(); i++ ) {
			char c = str.charAt(i);
			
			if(!map.containsKey(c))
				answer.push(c);
			
			if(map.containsKey(c)) {
				char top = answer.isEmpty() ? '#' : answer.peek();
				if(top != map.get(c))
					return false;
				else
					answer.pop();
			}
		}
		return answer.isEmpty();
	}

}
