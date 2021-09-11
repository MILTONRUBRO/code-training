package br.com.devmos.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilNumbersTest {

	@Test
	public void testNumeroAleatorio() {
		int numeroAleatorio = UtilNumbers.numeroAleatorio(5, 8);
		assertTrue(numeroAleatorio <= 8);
	}

}
