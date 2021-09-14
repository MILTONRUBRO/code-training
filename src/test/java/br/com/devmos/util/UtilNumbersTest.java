package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

}
