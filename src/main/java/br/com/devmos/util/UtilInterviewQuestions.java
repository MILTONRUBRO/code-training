package br.com.devmos.util;

import java.util.HashMap;
import java.util.Map;

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

}
