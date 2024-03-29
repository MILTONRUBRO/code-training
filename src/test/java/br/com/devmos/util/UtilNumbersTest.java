package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.devmos.model.GausLegendre;

public class UtilNumbersTest {
	
	@Test
	public void testNumeroAleatorio() {
		int numeroAleatorio = UtilNumbers.numeroAleatorio(5, 8);
		assertTrue(numeroAleatorio <= 8);
	}
	
	@Test
	public void testGeraSenhaNumerica() {
		String senha = UtilNumbers.geraSenhaNumerica(8);
		assertEquals(8, senha.length());
	}
	
	@Test
	public void testGeraSenhaLetras() {
		String senha = UtilNumbers.geraSenhaLetras(8);
		assertFalse(senha.isEmpty());
		assertEquals(8, senha.length());
	}
	
	@Test
	public void testGetMinNumber() {
		var numbers = List.of(6,87,78,3,4);
		int minNumber = UtilNumbers.getMinNumber(numbers);
		assertEquals(3, minNumber);
	}
	
	@Test
	public void testGetMinNumberWithEmptyList() {
		var numbers = new ArrayList<Integer>();
		int minNumber = UtilNumbers.getMinNumber(numbers);
		assertEquals(Integer.MIN_VALUE, minNumber);
	}
	
	@Test
	public void testGetMaxNumber() {
		var numbers = List.of(6,87,78,3,4);
		int maxNumber = UtilNumbers.getMaxNumber(numbers);
		assertEquals(87, maxNumber);
	}
	
	@Test
	public void testGetAverage() {
		var numbers = List.of(6,2,4,7,1);
		double average = UtilNumbers.getAverage(numbers);
		assertEquals(4.0, average, 0.001);
	}
	
	@Test
	public void testGetSum() {
		var numbers = List.of(6,2,4,7,1);
		int sum = UtilNumbers.getSum(numbers);
		assertEquals(20, sum);
	}
	
	@Test
	public void testGeraCEP() {
		String cep = UtilNumbers.geraCEP();
		assertEquals(9, cep.length());
	}
	
	@Test
	public void testGeraPlacaVeiculo() {
		String placa = UtilNumbers.geraPlacaVeiculo();
		assertEquals(8, placa.length());
	}
	
	@Test
	public void testGetMaxSubArraySum() {
		int numbers[] = {2, -5, 10, -1, 4, -10};
		int maxSum = UtilNumbers.maxSubArraySum(numbers);
		assertEquals(13, maxSum);
	}
	
	@Test
	public void testIsPrime() {
		boolean prime = UtilNumbers.isPrime(19);
		assertEquals(true, prime);
	}
	
	@Test
	public void testIsPrimeFalse() {
		boolean prime = UtilNumbers.isPrime(4);
		assertEquals(false, prime);
	}
	
	@Test
	public void testGetPotencia() {
		Double result = UtilNumbers.getPotencia(2.0, 3.0);
		assertEquals(8.0, result, 0.001);
	}
	
	@Test
	public void testPIGenerate() {
		double pi = GausLegendre.pi(3);
		assertEquals(3.1415, pi, 0.001);

	}
	
	@Test
	public void testfactorial() {
		long factorial = UtilNumbers.factorial(5);
		assertEquals(120, factorial);
	}
	
	@Test
	public void testMinAndMaxOk(){
		var numbers = Arrays.asList(6,87,78,3,4);
		UtilNumbers.minAndMax(numbers);
		assertFalse(numbers.isEmpty());
	}
	
	@Test
	public void testRemoveAllNegativeNumbers(){
		var numbers = Arrays.asList(1, -2, -3, 7);
		List<Integer> removeAllNegativeNumbers = UtilNumbers.removeAllNegativeNumbers(numbers);
		assertEquals(2, removeAllNegativeNumbers.size());
	}
	
	@Test
	public void testRemoveAllOddNumbers() {
		var numbers = List.of(6,2,4,7,1);
		List<Integer> list = UtilNumbers.removeAllOddNumbers(numbers);
		assertEquals(List.of(6,2,4), list);
	}
	
	@Test
	public void testToken(){
		Integer token = UtilNumbers.token();
		assertNotNull(token);
	}
	
	@Test
	public void testGetMegaSena(){
		String megaSena = UtilNumbers.getMegaSena();
		assertFalse(megaSena.isEmpty());
	}
	
	@Test
	public void testGenerateAuthenticator(){
		String pass = UtilNumbers.generateAuthenticator();
		assertFalse(pass.isEmpty());
		assertEquals(6, pass.length());
	}
	
	@Test
	public void testGetCandles(){
		var numbers = List.of(3,2,4,2,1,5,5,5);
		Integer candles = UtilNumbers.candles(numbers);
		assertEquals(Integer.valueOf(3), candles);
	}
	
	
	@Test
	public void testDiagonalDifference() {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		
		var row1 = List.of(11, 2, 4);
		var row2 = List.of(4, 5, 6);
		var row3 = List.of(10, 8, -12);
		
		matrix.add(row1);
		matrix.add(row2);
		matrix.add(row3);
		
		int result = UtilNumbers.diagonalDifference(matrix);
		assertEquals(15, result);
	}
	
	@Test
    public void testBinaryToDecimalOk() {
		int num = UtilNumbers.binaryToDecimal("100001011");
		assertEquals(267, num);
    }
	
	@Test
    public void testDecimalToBinary() {
		String binary = UtilNumbers.decimalToBinary(11);
		assertEquals("1011", binary);
	}
	
	@Test
	public void testGetLogNeperiano(){
		double result = UtilNumbers.getLogNeperiano(100);
		assertEquals(4.6051, result, 0.0001);
	}
	
	@Test
	public void testFlippingMatrix() {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		
		var row1 = List.of(2, 2);
		var row2 = List.of(4, 3);
		
		matrix.add(row1);
		matrix.add(row2);
		
		int result = UtilNumbers.flippingMatrix(matrix);
		assertEquals(4, result);
	}
	
	@Test
	public void testCalcHipotenusa() {
		double hiponetusa = UtilNumbers.calcHipotenusa(2, 3);
		assertEquals(3.605551, hiponetusa, 0.0001);
	}
	
	@Test
	public void testRemoveNonNumbers() {
		String number = UtilNumbers.removeNonNumerics("11#$%11111*&�1111&*(");
		assertEquals("11111111111", number);
	}
	
	@Test
	public void testRemoveDuplicateWithDistinct() {
		List<Integer> numbers = List.of(1,8, 9, 65,1);
		List<Integer> response = UtilNumbers.removeDuplicateWithDistinct(numbers);
		assertEquals(4, response.size());
	}

}
