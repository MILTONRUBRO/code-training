package br.com.devmos.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
	
	@Test
	public void testMissingNumber() {
		int[] nums = {0,1,5,3,2};
		int numeroFaltante = UtilInterviewQuestions.missingNumber(nums);
		assertEquals(4, numeroFaltante);
	}
	
	@Test
	public void testFirstNonRepeatingCharacter() {
		String str = "abacabad";
		char result = UtilInterviewQuestions.firstNonRepeatingCharacter(str);
		assertEquals('c', result);
	}
	
	
	@Test
	public void testBinarySearch() {
		int[] nums = {0,1,2,3,5,7};
		int posicao = UtilInterviewQuestions.binarySearch(nums, 5);
		assertEquals(4, posicao);
	}
	
	@Test
	public void testDailyTemperatures() {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] responses = UtilInterviewQuestions.dailyTemperatures(temperatures);
		
		assertArrayEquals(responses, new int[] {1, 1, 4, 2, 1, 1, 0, 0});
	}
	
	@Test
	public void testFindDuplicate() {
		int[] numbers = {2, 4, 1, 5, 3, 6, 8, 7, 4};
		int response = UtilInterviewQuestions.findDuplicate(numbers);
		
		assertEquals(4, response);
	}
	
	@Test
	public void testSumWithoutOperators() {
		int numero = UtilInterviewQuestions.sumWithoutOperators(21, 30);
		assertEquals(51, numero);
	}
	
	@Test
	public void testSockMerchantOk() {
		var pileSocks = List.of(10,20,20,30,10,40,20,35,50);		
		int pares = UtilInterviewQuestions.sockMerchant(pileSocks);
		assertEquals(2, pares);
	}
	
	@Test
	public void testCalcBinominalCoeficienteOk() {
		int result = UtilInterviewQuestions.calcBinominalCoeficiente(5, 2);
		assertEquals(10, result);
	}

}
