package br.com.devmos.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	
	@Test
	public void testGeraSenhaLetras() {
		String senha = UtilNumbers.geraSenhaLetras(8);
		assertFalse(senha.isEmpty());
		assertEquals(8, senha.length());
	}

}
