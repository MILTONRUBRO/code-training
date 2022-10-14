package br.com.devmos.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.com.devmos.model.LinkedList;

public class LinkedListTest {

	@Test
	public void test() throws Exception {
		LinkedList<Integer> numbers = new LinkedList<>();
		
		numbers.add(2);
		numbers.add(5);
		numbers.add(5);
		numbers.add(7);
		numbers.add(10);
		numbers.add(6);
		
		assertEquals(2, numbers.getFirst());
		assertEquals(6, numbers.getLast());


	}

}
