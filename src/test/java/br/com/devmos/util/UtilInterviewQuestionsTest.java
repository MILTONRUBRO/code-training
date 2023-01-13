package br.com.devmos.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.devmos.model.Car;
import br.com.devmos.model.Kid;

public class UtilInterviewQuestionsTest {

	@Test
	public void testTwoSum() {
		int[] nums = { 2, 7, 11, 15 };
		int[] twoSum = UtilInterviewQuestions.twoSum(nums, 9);

		assertArrayEquals(twoSum, new int[] { 0, 1 });
	}

	@Test
	public void testMaxProfit() {
		int[] stocks = { 7, 1, 5, 3, 6, 4 };
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
		int[] nums = { 0, 1, 5, 3, 2 };
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
		int[] nums = { 0, 1, 2, 3, 5, 7 };
		int posicao = UtilInterviewQuestions.binarySearch(nums, 5);
		assertEquals(4, posicao);
	}

	@Test
	public void testDailyTemperatures() {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] responses = UtilInterviewQuestions.dailyTemperatures(temperatures);

		assertArrayEquals(responses, new int[] { 1, 1, 4, 2, 1, 1, 0, 0 });
	}

	@Test
	public void testFindDuplicate() {
		int[] numbers = { 2, 4, 1, 5, 3, 6, 8, 7, 4 };
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
		var pileSocks = List.of(10, 20, 20, 30, 10, 40, 20, 35, 50);
		int pares = UtilInterviewQuestions.sockMerchant(pileSocks);
		assertEquals(2, pares);
	}

	@Test
	public void testCalcBinominalCoeficienteOk() {
		int result = UtilInterviewQuestions.calcBinominalCoeficiente(5, 2);
		assertEquals(10, result);
	}

	@Test
	public void testMaxSubArraySum() {
		int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int sum = UtilInterviewQuestions.maxSubArraySum(nums);
		assertEquals(7, sum);
	}

	@Test
	public void testMissingNumberWithArguments() {
		int[] nums = { 6, 1, 2, 8, 3, 4, 7, 10, 5 };
		int sum = UtilInterviewQuestions.missingNumber(nums, 10);
		assertEquals(9, sum);
	}

	@Test
	public void testAvancaLetra() {
		Character letra = UtilInterviewQuestions.avancaLetra('W', 87);
		assertEquals(Character.valueOf('F'), letra);
	}

	@Test
	public void testCaesarCipher() {
		String mensagemCifrada = UtilInterviewQuestions.caesarCipher("middle-Outz", 2);
		assertEquals("okffng-Qwvb", mensagemCifrada);
	}

	@Test
	public void testCaesarCipherWitNegativeNumers() {
		String mensagemCifrada = UtilInterviewQuestions.caesarCipher("milton", -2);
		assertEquals("kgjrml", mensagemCifrada);
	}

	@Test
	public void testLizardSpockGameDraw() {
		String result = UtilInterviewQuestions.lizardSpockGame("lagarto", "lagarto");
		assertEquals("De novo!", result);
	}

	@Test
	public void testLizardSpockGameSheldonWins() {
		String result = UtilInterviewQuestions.lizardSpockGame("lagarto", "papel");
		assertEquals("Bazinga!", result);
	}

	@Test
	public void testLizardSpockGameRajWins() {
		String result = UtilInterviewQuestions.lizardSpockGame("papel", "lagarto");
		assertEquals("Raj trapaceou!", result);
	}

	@Test
	public void testRemoveNoAlphabet() {
		String frase = UtilInterviewQuestions.removeNoAlphabet("ola, como voce esta hoje");
		assertEquals("olacomovoceestahoje", frase);
	}

	@Test
	public void testContaLetrasMalElaborada() {
		String contaLetras = UtilInterviewQuestions.contaLetras("ola, como voce esta hoje");
		assertEquals("frase mal elaborada", contaLetras);
	}

	@Test
	public void testContaLetras() {
		String contaLetras = UtilInterviewQuestions
				.contaLetras("hoje fui na feira, e comprei banana, melao e abacates");
		assertEquals("frase quase completa", contaLetras);
	}

	@Test
	public void testSherlockStringNo() {
		String sherlockString = UtilInterviewQuestions.sherlockString("aabbcd");
		assertEquals("NO", sherlockString);
	}

	@Test
	public void testSherlockStringYes() {
		String sherlockString = UtilInterviewQuestions.sherlockString("aabbccc");
		assertEquals("YES", sherlockString);
	}

	@Test
	public void testSundayMorning() {
		String sundayMorning = UtilInterviewQuestions.sundayMorning("09:30");
		assertEquals("Atraso maximo: 12030", sundayMorning);
	}

	@Test
	public void testFasesLua() {
		String fase = UtilInterviewQuestions.fasesLua(2, 95);
		assertEquals("crescente", fase);
	}

	@Test
	public void testGetPasswordRa() {
		String passwordRa = UtilInterviewQuestions.getPasswordRa("o rato roeu a roupa de margarida");
		assertEquals("470947440074", passwordRa);
	}

	@Test
	public void testGetPasswordRaSecondPhrase() {
		String passwordRa = UtilInterviewQuestions.getPasswordRa("OlA TuDo CeRtO");
		assertEquals("216405474992", passwordRa);
	}

	@Test
	public void testGetAsc() {
		int asc = UtilInterviewQuestions.getAsc('A');
		assertEquals(65, asc);
	}

	@Test
	public void testRemoveNulls() {
		List<Object> names = Arrays.asList("ana", null, "jose");
		List<Object> list = UtilInterviewQuestions.removeNulls(names);
		assertEquals(2, list.size());
	}

	@Test
	public void testBooleanPrimitiveToIntTernaryTrue() {
		int result = UtilInterviewQuestions.booleanPrimitiveToIntTernary(true);
		assertEquals(1, result);
	}

	@Test
	public void testBooleanPrimitiveToIntTernaryFalse() {
		int result = UtilInterviewQuestions.booleanPrimitiveToIntTernary(false);
		assertEquals(0, result);
	}

	@Test
	public void testToHumanReadable() {
		String humanReadable = UtilInterviewQuestions.toHumanReadable(16);
		assertEquals("16 Bytes", humanReadable);
	}

	@Test
	public void testIsAutomorphicNumberTrue() {
		boolean automorphicNumber = UtilInterviewQuestions.isAutomorphicNumber(25);
		assertEquals(true, automorphicNumber);
	}

	@Test
	public void testIsAutomorphicNumberFalse() {
		boolean automorphicNumber = UtilInterviewQuestions.isAutomorphicNumber(8);
		assertEquals(false, automorphicNumber);
	}

	@Test
	public void testToHumanReadableKB() {
		String humanReadable = UtilInterviewQuestions.toHumanReadable(1024);
		assertEquals("1 KB", humanReadable);
	}

	@Test
	public void testToHumanReadableMB() {
		String humanReadable = UtilInterviewQuestions.toHumanReadable(100_000_000);
		assertEquals("95,37 MB", humanReadable);
	}

	@Test
	public void testFindDistinctStrings() {
		List<String> list = UtilInterviewQuestions.findDistinctStrings(Arrays.asList("A", "E", "E", "I"));
		assertEquals(3, list.size());
	}

	@Test
	public void testToUpper() {
		List<String> letters = UtilInterviewQuestions.toUpper(Arrays.asList("a", "e", "i", "o", "u"));
		assertTrue(letters.contains("A"));
	}

	@Test
	public void testRemoveData() {
		List<Car> cars = new ArrayList<>();
		
		var car1 = new Car("Azul", "Civic");
		var car2 = new Car("Preto", "Corolla");
		var car3 = new Car("Vermelho", "");
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		List<Car> list = UtilInterviewQuestions.removeData(cars);
		
		assertEquals(2, list.size());

	}
	
	@Test
	public void testSumWithReduce() {
		int numbers[] = {1, 5, 4};
		int sum = UtilInterviewQuestions.sumWithReduce(numbers);
		assertEquals(10, sum);
	}
	
	@Test
	public void testSoma() {
		int[] numeros = {3, 4, 2};
		int soma = UtilInterviewQuestions.soma(numeros);
		assertEquals(9, soma);
	}
	
	@Test
	public void testFindJudge() {
		
		int[][] peoples = {{1,3}, {2,3}};
		
		int judge = UtilInterviewQuestions.findJudge(3, peoples);
		assertEquals(3, judge);

	}
	
	@Test
	public void testMontaTabela() {
		Map<Character, Character> montaTabela = UtilInterviewQuestions.montaTabela("eljuxhpwnyrdgtqkviszcfmabo");
		assertNotNull(montaTabela);
	}
	
	@Test
	public void testDecifraMensagem() {
		String mensagem = UtilInterviewQuestions.decifraMensagem("eljuxhpwnyrdgtqkviszcfmabo", 
				"zwx hnfx lqantp mnoeius ycgk vcnjrdb");
		
		assertEquals("the five boxing wizards jump quickly", mensagem);
	}
	
	
	@Test
	public void testReverseString() {
		char[] c = {'h','e','l','l'};
		c = UtilInterviewQuestions.reverseArrayChar(c);
		assertEquals('l', c[0]);
	}
	
	@Test
	public void testCheesBorder() {
		boolean result = UtilInterviewQuestions.valueOfCheesBorder("a1");
		assertEquals(Boolean.FALSE, result);
	}
	
	@Test
	public void testPrintBinary() {
		String binary = UtilInterviewQuestions.printBinary(.125);
		assertEquals("devem ser iguais", ".001", binary);
	}
	
	@Test
	public void testRunFamilies() {
		double result = UtilInterviewQuestions.runFamilies(15);
		assertTrue(result > 0);
	}
	
	@Test
	public void testIsPalindrome() {
		boolean result = UtilInterviewQuestions.isPalindrome("ovo");
		assertTrue(result);
	}
	
	@Test
	public void testIsPalindromeRecursive() {
		boolean result = UtilInterviewQuestions.isPalindromeRecursive("ovo");
		assertTrue(result);
	}
	
	@Test
	public void testIsPalindromeRecursiveFalse() {
		boolean result = UtilInterviewQuestions.isPalindromeRecursive("teste");
		assertFalse(result);
	}
	
	@Test
	public void testIsPalindromeReverseTheString() {
		boolean result = UtilInterviewQuestions.isPalindromeReverseTheString("ana");
		assertTrue(result);
	}
	
	@Test
	public void testIsPalindromeUsingStringBuilder() {
		boolean result = UtilInterviewQuestions.isPalindromeUsingStringBuilder("nnaann");
		assertTrue(result);
	}
	
	@Test
	public void testIsPalindromeReverseTheStringFalse() {
		boolean result = UtilInterviewQuestions.isPalindromeReverseTheString("anad");
		assertFalse(result);
	}
	
	@Test
	public void testPecasDominos() {
		int result = UtilInterviewQuestions.pecasDominos(6);
		assertEquals(28, result);
	}
	
	@Test
	public void testfatorialRecursivo() {
		int result = UtilInterviewQuestions.fatorialRecursivo(3);
		assertEquals(6, result);
	}
	
	@Test
	public void testRouteOfGifts() {
		
		List<Kid> kids = new ArrayList<>();
		
		kids.add(new Kid("Samuel", "O", 1));
		kids.add(new Kid("Fabricio", "L", 1));
		kids.add(new Kid("Antonieta", "L", 1));
		kids.add(new Kid("Emanuel", "S", 30));
		kids.add(new Kid("Kaio", "S", 20));
		kids.add(new Kid("Hugo", "N", 90));
		
		List<String> names = UtilInterviewQuestions.routeOfGifts(kids);
		
		assertEquals("Antonieta", names.get(0));
	}
	
	@Test
	public void testReplaceWords() {
		String removeWords = UtilInterviewQuestions.replaceWords("O blue blueberry blues ablue");
		System.out.println(removeWords);
	}
	
	@Test
	public void testValidPasswordOk() {
		String pass = UtilInterviewQuestions.validPassword("password");
		assertEquals("Senha valida", pass);
	}
	
	@Test
	public void testValidPasswordNotOk() {
		String pass = UtilInterviewQuestions.validPassword("pass");
		assertEquals("Senha invalida", pass);
	}
	
	@Test
	public void testLessThanThree() {
		var numbers = List.of(10, 2, 5, 1);
		List<Integer> result = UtilInterviewQuestions.lessThanThree(numbers);
		assertTrue(result.contains(2));
	}
	
	@Test
	public void testInternationalTalkEnglishAnswer() {
		var languages = List.of("portugues", "chines", "portugues");
		String language = UtilInterviewQuestions.internationalTalk(languages);
		assertEquals("ingles", language);
	}
	
	@Test
	public void testInternationalTalkLanguage() {
		var languages = List.of("portugues", "portugues");
		String language = UtilInterviewQuestions.internationalTalk(languages);
		assertEquals("portugues", language);
	}
}
