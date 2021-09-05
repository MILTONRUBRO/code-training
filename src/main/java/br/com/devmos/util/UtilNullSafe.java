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
	
}
