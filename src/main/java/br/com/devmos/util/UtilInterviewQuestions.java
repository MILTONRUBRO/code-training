package br.com.devmos.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	/**
	 * Algoritmo de busca binaria
	 * @param nums
	 * @param target
	 * @return
	 */
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
	
	/**
	 * Aloritmo de insercao no metodo sort
	 * @param arr
	 */
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
	/**
	 * dado um numero nao negativo numRow gere a primeira 
	 * numRow do triangulo de Pascal
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> pascalTriangle(int numRows){
		List<List<Integer>> integers = new ArrayList<List<Integer>>();
		
		int c = 1;
		int line = 1;
		
		for(; line <= numRows; line++) {
			List rows = new ArrayList();
			c = 1;
			for(int i = 1; i <= line; i++) {
				rows.add(c);
				c = c * (line-1)/i;
			}
			integers.add(rows);
		}
		return integers;
	}
	
	public static int getContainerWithMostWater(int[] heights) {
		int start = 0;
		int end = heights.length - 1;
		int area = 0;
		
		while(start < end) {
			area = Math.max(area, Math.min(heights[start], heights[end]) * (end-start));
			if(heights[start] < heights[end])
				start++;
			else
				end--;
		}
		return area;
	}
	
	public static int[] dailyTemperatures(int[] nums) {
		int size = nums.length;
		int answer[] = new int[size];
		
		for(int i = 0; i < size-1; i++) {
			int flag = 0;
			
			for(int j = i+1; j < size; j++) {
				if(nums[j] > nums[i]) {
					answer[i] = j-i;
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				answer[i] = 0;
			}
		}
		answer[size-1] = 0;
		return answer;
	}
	
	/**
	 * Usando o algoritmo de Floyd ou algoritmo da lebre e tartaruga para encontrar valor duplicado no array
	 * @return
	 */
	public static int findDuplicate(int[] numbers) {
		int size = numbers.length;
		
		if(size <= 1)
			return -1;
		
		int slow = numbers[0];
		int fast = numbers[numbers[0]];
		
		while(fast != slow) {
			slow = numbers[slow];
			fast = numbers[numbers[fast]];
		}
		
		fast = 0;
		
		while(slow != fast) {
			slow = numbers[slow];
			fast = numbers[fast];
		}
		
		return slow;
	}

}
