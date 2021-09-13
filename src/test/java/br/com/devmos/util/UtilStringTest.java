package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilStringTest {
	
	private static final String STRING_WITH_ONLY_DIGIT = "1322141";
	private static final String STRING_WITH_LETTER_AND_DIGIT = "132FF2141";
	private static final String NAME = "Ragnar";


	@Test
	public void testContainsOnlyDigitsTrue() {
		boolean containsOnlyDigits = UtilString.containsOnlyDigits(STRING_WITH_ONLY_DIGIT);
		assertTrue(containsOnlyDigits);
	}
	
	@Test
	public void testContainsOnlyDigitsFalse() {
		boolean containsOnlyDigits = UtilString.containsOnlyDigits(STRING_WITH_LETTER_AND_DIGIT);
		assertFalse(containsOnlyDigits);
	}
	
	@Test
	public void testRemoveCharacter() {
		String removedCharacter = UtilString.removeCharacter(NAME, 'R');
		assertEquals("agnar", removedCharacter);
	}

}
