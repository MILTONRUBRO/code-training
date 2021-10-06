package br.com.devmos.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class UtilInterviewQuestionsTest {
	
	@Test
	public void testTwoSum() {
		int[] nums = {2, 7, 11, 15};
		int[] twoSum = UtilInterviewQuestions.twoSum(nums, 9);
		
		assertArrayEquals(twoSum, new int[] {0, 1});
	}
	
	
	@Test
	public void testMaxProfit() {
		int[] stocks = {7, 1, 5, 3, 6, 4};
		int max = UtilInterviewQuestions.maxProfit(stocks);
		
		assertEquals(5, max);
	}
	
	@Test
	public void testIsValidFalse() {
		boolean answer = UtilInterviewQuestions.isValid("{[(])}");
		assertFalse(answer);
	}
	
	@Test
	public void testIsValidTrue() {
		boolean answer = UtilInterviewQuestions.isValid("{[()]}");
		assertTrue(answer);
	}
	
	@Test
	public void testRomanToInt() {
		int numero = UtilInterviewQuestions.romanToInt("XV");
		assertEquals(15, numero);
	}

}
