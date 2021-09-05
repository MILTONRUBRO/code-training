package br.com.devmos.util;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilNullSafeTest {
	
	private static final List<Integer> LISTA_SEM_NULL = Arrays.asList(1, 3, 5, 4);
	private static final List<Integer> LISTA_COM_NULL = Arrays.asList(1, 3, null, 4);


	@Test
	public void testlistaContemNullSemNull() {
		boolean contem = UtilNullSafe.listaContemNull(LISTA_SEM_NULL);
		assertEquals(false, contem);
	}
	
	@Test
	public void testlistaContemNullComListaNula() {
		List<Integer> integers = null;
		boolean contem = UtilNullSafe.listaContemNull(integers);
		assertEquals(false, contem);
	}
	
	@Test
	public void testlistaContemNullComNull() {
		boolean contem = UtilNullSafe.listaContemNull(LISTA_COM_NULL);
		assertEquals(true, contem);
	}
	
	@Test
	public void testSumIntegersComListaNula() {
		List<Integer> integers = null;
		
		IllegalArgumentException assertThrows = assertThrows(
				IllegalArgumentException.class, () -> UtilNullSafe.sumIntegers(integers));
		
		assertTrue(assertThrows.getMessage().contains("A lista não pode ser vazia"));
	}
	
	@Test
	public void testSumIntegersOk() {
		int sumIntegers = UtilNullSafe.sumIntegers(LISTA_COM_NULL);
		assertEquals(8, sumIntegers);
	}
	
	
}
