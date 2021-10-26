package br.com.devmos.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
	 * Dado um array de inteiros representado valor de ações
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
	 * return se é valido com a abertura e fechamento do mesmo tipo
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
	
	/**
	 * Converte numeros romanos em inteiros
	 * @param str
	 * @return
	 */
	public static int romanToInt(String str) {
		int[] map = new int[256];
		
		map['I'] = 1;
		map['V'] = 5;
		map['X'] = 10;
		map['L'] = 50;
		map['C'] = 100;
		map['D'] = 500;
		map['M'] = 1000;
		
		int ret = 0;
		int pre = 1;
		
		for(int i = str.length()-1; i >= 0; i--) {
			int cur = map[str.charAt(i)];
			if(cur < pre) {
				ret -= cur;
			}else {
				pre = cur;
				ret += cur;
			}
		}
		
		return ret;
	}
	
	/**
	 * Dado um array de numeros inteiros
	 * retorne o numero faltante na sequencia
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		int sum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		int total = (nums.length * (nums.length + 1))/2;
		
		return total - sum;
	}
	
	public static char firstNonRepeatingCharacter(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				return str.charAt(i);
			}
		}
		return '-';
	}
	
	public static Set<String> intersectionSet(Set<String> set1, Set<String> set2){
			set1.retainAll(set2);
			return set1;
	}
	
	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length -1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(target == nums[mid]) {
				return mid;
			}else if(target < nums[mid]) {
				right = mid-1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int j = i;
			
			while(j > 0 && arr[j-1] > value) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = value;
		}
	}

}
