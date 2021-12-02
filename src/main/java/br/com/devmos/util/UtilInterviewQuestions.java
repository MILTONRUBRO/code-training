package br.com.devmos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	
	/**
	 * retorna o maximo de ouro que pode ser coletado quando uma jornada starta
	 * @param gold
	 * @param m
	 * @param n
	 * @return
	 */
	public static int getMaxGold(int gold[][], int m, int n) {
		int goldTable[][] = new int[m][n];
		
		for(int[] rows : goldTable) {
			Arrays.fill(rows, 0);
		}
		
		for(int col = n-1; col >= 0; col--) {
			
			for(int row = 0; row < m; row++) {
				int right = (col == n-1) ? 0 : goldTable[row][col+1];
				int right_up = (row == 0 || col == n-1) ? 0 : goldTable[row-1][col+1];
				int right_down = (row == m-1 || col == n-1) ? 0 : goldTable[row+1][col+1];
				
				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));

			}
		}
		
		int res = goldTable[0][0];
		
		for(int i = 1; i < m; i++) {
			res = Math.max(res, goldTable[i][0]);
		}
		
		return res;
	}
	
	/**
	 * Add two numbers without using arithmetic operators
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int sumWithoutOperators(int num1, int num2) {
		while(num2 != 0) {
			int carry = num1 & num2;
			
			num1 = num1 ^  num2;
			num2 = carry << 1;
		}
		return num1;
	}
	
	/**
	 * Dado uma pilha de meias retorne os pares encontrados na lista
	 * @param sockers
	 * @return
	 */
	public static int sockMerchant(List<Integer> sockers) {
		Set<Integer> unmatched = new HashSet<>();
		int pairs = 0;
		
		for(int i = 0; i < sockers.size(); i++) {
			if(!unmatched.add(sockers.get(i))) {
				unmatched.remove(sockers.get(i));
				pairs++;
			}
		}
		return pairs;
	}
	
	public static int countWays(int n) {
		if(n == 1)
			return 4;
		
		int countB = 1;
		int countS = 1;
		int prevCountB;
		int prevCountS;
		
		for(int i = 2; i <= n; i++) {
			prevCountB = countB;
			prevCountS = countS;
			
			countS = prevCountB + prevCountS;
			countB = prevCountS;
		}
		
		int result = countS + countB;
		
		return (result * result);
	}
	
	public static long countWays(int s[], int m, int n) {
		long[] table = new long[n+1];
		
		Arrays.fill(table, 0);
		table[0] = 1;
		
		for(int i = 0; i < m; i++) {
			for(int j = s[i]; j <= n; j++) {
				table[j] += table[j - s[i]];
			}
		}
		
		return table[n];
	}
	
	public static int calcBinominalCoeficiente(int n, int k) {
		if(k > n)
			return 0;
		if(k == 0 || k == n)
			return 1;
		
		return calcBinominalCoeficiente(n - 1, k -1) + calcBinominalCoeficiente(n - 1, k);
	}
	
	public static int[] reverseArrayInGrups(int arr[], int n, int k){
		for(int i = 0; i < n; i += k) {
			
			int left = i;
			int right = Math.min(i + k - 1, n - 1);
			int temp;
			
			while(left < right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				
				left += 1;
				right -= 1;
			}
		}
		
		return arr;
	}
	
	public static int maxSubArraySum(int numbers[]) {
		int size = numbers.length;
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		
		for(int i = 0; i < size; i++) {
			maxEndingHere = maxEndingHere + numbers[i];
			
			if(maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
			if(maxEndingHere < 0)
				maxEndingHere = 0;
		}
		return maxSoFar;
	}


}
