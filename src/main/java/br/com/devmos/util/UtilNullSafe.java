package br.com.devmos.util;

import java.util.List;
import java.util.Objects;

public class UtilNullSafe {
	
	public static boolean listaContemNull(List<Integer> integers) {
		if(Objects.isNull(integers)) {
			return false;
		}
		return integers.stream().anyMatch(Objects::isNull);
	}
	
	public static int sumIntegers(List<Integer> integers) {
		if(Objects.isNull(integers)) {
			throw new IllegalArgumentException("A lista não pode ser vazia");
		}
		return integers.stream()
				.filter(Objects::nonNull)
				.mapToInt(Integer::intValue)
				.sum();
	}
	
}
