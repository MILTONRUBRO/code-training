package br.com.devmos.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import br.com.devmos.model.Book;

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
	
	@Test
	public void testDistinct() {
		var b1 = new Book();
		b1.setId(1L);
		
		var b2 = new Book();
		b2.setId(2L);
		
		var b3 = new Book();
		b3.setId(3L);
		
		var b4 = new Book();
		b4.setId(4L);
		
		List<Book> books = new ArrayList<>();
		List<Book> list = new ArrayList<>();
		books.add(b1);
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		list.add(b1);
		list.add(b4);
		
		Predicate<Book> notIn2 = s -> books.stream().allMatch(b -> b.getId().equals(b.getId()));

		remove(books,notIn2);
		
		/*List<Book> distinctElements = books.stream()
	              .filter( distinctByKey(p -> p.getIsbn()) )
	              .collect( Collectors.toList() ); */
		
		
		/*List<Book> list3 = books.stream().filter(notIn2).collect(Collectors.toList());
		
		Map<String, List<Book>> agePersonMap =
				books.stream()
		            .collect(Collectors.groupingBy(Book::getIsbn)); */

		System.out.println("REMOVED:" + books);
		
	}
	
	public static <T> void remove(List<T> list, Predicate<T> predicate)
	{
	    Collection collection = new ArrayList<>();
	    for (T t: list)
	    {
	        if (predicate.test(t)) {
	            collection.add(t);
	        }
	    }
	    list.removeAll(collection);
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
	  Map<Object, Boolean> map = new ConcurrentHashMap<>();
	  return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	public static <T> ArrayList<T> removeDuplicates(List<T> list){
		  Set<T> set = new LinkedHashSet<>(list);
		  return new ArrayList<T>(set);
	}
}
