package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
	
	@Test
	public void testOrdenaPeloTamanho() {
		List<String> frutas = Arrays.asList("maçã", "banana", "uva", "melancia");
		List<String> frutasOrdenadas = UtilString.ordenaPeloTamanho(frutas);
		
		assertEquals("uva", frutasOrdenadas.get(0));
	}
	
	@Test
	public void testOrdena() {
		List<String> frutas = Arrays.asList("maçã", "banana", "uva", "melancia");
		List<String> frutasOrdenadas = UtilString.ordena(frutas);
		
		assertEquals("banana", frutasOrdenadas.get(0));
	}
	
	@Test
	public void testRemoveRepeated() {
		List<String> frutas = Arrays.asList("maçã", "banana", "uva", "melancia", "uva");
		Set<String> frutasSemRepeticoes = UtilString.removeRepeated(frutas);
		
		assertEquals(4, frutasSemRepeticoes.size());
	}
	
	@Test
	public void testLetraAlfabetoParaNumerico() {
		int num = UtilString.letraAlfabetoParaNumerico('A');
		
		assertEquals(1, num);
	}
	
	@Test
	public void testIsStringOnlyAlphabet() {
		boolean response = UtilString.isStringOnlyAlphabet(STRING_WITH_LETTER_AND_DIGIT);
		
		assertEquals(false, response);
	}
}
