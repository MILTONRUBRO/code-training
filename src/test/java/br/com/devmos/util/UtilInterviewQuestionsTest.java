package br.com.devmos.util;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class UtilInterviewQuestionsTest {
	
	@Test
	public void testTwoSum() {
		int[] nums = {2, 7, 11, 15};
		int[] twoSum = UtilInterviewQuestions.twoSum(nums, 9);
		
		assertArrayEquals(twoSum, new int[] {0, 1});
	}

}
