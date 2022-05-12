package br.com.devmos.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.devmos.model.Book;

public class UtilStream {

	public Map<String, String> listToMap(List<Book> books) {
		return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
	}

}
