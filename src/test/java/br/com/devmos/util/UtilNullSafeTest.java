package br.com.devmos.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilNullSafeTest {

	@Test
	public void testlistaContemNullSemNull() {
		List<Integer> integers = Arrays.asList(1, 3, 5, 4);
		boolean contem = UtilNullSafe.listaContemNull(integers);
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
		List<Integer> integers = Arrays.asList(1, 3, null, 5, 4);
		boolean contem = UtilNullSafe.listaContemNull(integers);
		assertEquals(true, contem);
	}
}
