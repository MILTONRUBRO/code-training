package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class UtilStringTest {
	
	private static final String STRING_WITH_ONLY_DIGIT = "1322141";
	private static final String STRING_WITH_LETTER_AND_DIGIT = "132FF2141";
	private static final String NAME = "Ragnar";
	private static final String FRASE = "pastel comprar feira na fui";
	private static final String HTML_WITH_COMMENTS = "<html>\r\n"
			+ "<head>\r\n"
			+ "  <title>Title of the document</title>\r\n"
			+ "</head>\r\n"
			+ "\r\n"
			+ "<body>\r\n"
			+ "<!-- this is a comment -->"
			+ "  <h1>This is a heading</h1>\r\n"
			+ "  <p>This is a paragraph.</p>\r\n"
			+ "</body>\r\n"
			+ "\r\n"
			+ "</html>";
	
	private static final String HTML_WITHOUT_COMMENTS = "<html>\r\n"
			+ "<head>\r\n"
			+ "  <title>Title of the document</title>\r\n"
			+ "</head>\r\n"
			+ "\r\n"
			+ "<body>\r\n"
			+ "  <h1>This is a heading</h1>\r\n"
			+ "  <p>This is a paragraph.</p>\r\n"
			+ "</body>\r\n"
			+ "\r\n"
			+ "</html>";


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
	
	@Test
	public void testReverterOrdemString() {
		String reverterOrdemString = UtilString.reverterOrdemString(FRASE);
		String str = "fui na feira comprar pastel";
		assertEquals(str, reverterOrdemString);
	}
	
	@Test
	public void testRemoveNonAlphabetChar() {
		String result = UtilString.removeNonAlphabetChar("Azad is a good boy, isn't he ?");
		assertEquals("Azad is a good boy isn t he", result);
	}
	
	@Test
	public void testGetRandomNameFromList() {
		List<String> frutas = Arrays.asList("maria", "jose", "joaquim", "joao");
		String randomName = UtilString.getRandomNameFromList(frutas);
		
		assertFalse(randomName.isEmpty());
	}
	
	@Test
	public void testIsPalindrome() {
		String str = "ovo";
		boolean isPalindrome = UtilString.isPalindrome(str);
		assertTrue(isPalindrome);
	}
	
	@Test
	public void testRemoveComentsHtml() {
		String result = UtilString.removeComentsHtml(HTML_WITH_COMMENTS);
		assertEquals(HTML_WITHOUT_COMMENTS, result);
	}
	
	@Test
	public void testRepeatStringWithSpace() {
		String result = UtilString.repeatStringWithSpace("call", 3);
		assertEquals("callcallcall", result);
	}
	
	@Test
	public void testCountVowels() {
		int totalVowels = UtilString.countVowels(FRASE);
		
		assertEquals(10, totalVowels);
	}
	
	
	@Test
	public void testFindDuplicate() {
		Character result = UtilString.findDuplicate("abydby");
		assertEquals(Character.valueOf('b'), result);
	}
	
	@Test
	public void testEncryptString() {
		String encryptString = UtilString.encryptString("hello", 2);
		assertEquals("1101", encryptString);
	}
	
	
	@Test
	public void testIsCommonSubstringTrue() {
		boolean isCommon = UtilString.isCommonSubstring("abra", "kadabra");
		assertTrue(isCommon);
	}
	
	@Test
	public void testIsCommonSubstringFAlse() {
		boolean isCommon = UtilString.isCommonSubstring("lucario", "eevee");
		assertFalse(isCommon);
	}
	
	@Test
	public void testGetSecurePasword() throws NoSuchAlgorithmException {
		String securePasword = UtilString.getSecurePasword("password", "2");
		assertFalse(securePasword.isEmpty());
	}
	
	@Test
	public void testRevert() {
		String reverted = UtilString.revert(NAME);
		assertEquals("rangaR", reverted);
	}
	
	@Test
	public void testGetNamesWithDeterminateLetter() {
		List<String> names = List.of("Jose", "Ana", "Antonio");
		List<String> response = UtilString.getNamesWithDeterminateLetter("A", names);
		
		assertTrue(response.contains("Ana"));
		assertTrue(response.contains("Antonio"));
	}
	
	@Test
	public void filterListWithCollectionOfPredicatesUsingAnd() {
		List<String> names = List.of("Aderbaldo", "Fatima", "Adelbina");
		List<String> response = UtilString.filterListWithCollectionOfPredicatesUsingAnd(names);
		
		assertEquals(2, response.size());
	}
	
	@Test
	public void testCommonChildString() {
		String result = UtilString.commonChildString("HARRY","SALLY");
		assertEquals("AY", result);
	}
	
	@Test
	public void testListWithoutBlank() {
		List<String> names = List.of("jose", " ", "maria");
		List<String> response = UtilString.listWithoutBlank(names);
		assertEquals(2, response.size());
	}
}
