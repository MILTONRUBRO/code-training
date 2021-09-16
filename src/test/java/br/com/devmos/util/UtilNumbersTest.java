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
}
