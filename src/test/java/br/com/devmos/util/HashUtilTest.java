package br.com.devmos.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashUtilTest {

	@Test
	void testgetHashCodeOk() {		
		long hash = HashUtil.getHash("limbosa");
		assertEquals(682914346648L, hash);
	}
	
	@Test
	void testDesHashCodeOk() {
		String str = HashUtil.desHash(682914346648L);
		assertEquals("limbosa", str);
	}

}
