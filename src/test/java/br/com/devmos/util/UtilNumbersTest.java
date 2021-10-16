package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
	
}
