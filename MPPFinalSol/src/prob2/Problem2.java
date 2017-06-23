package prob2;

import helperclasses.Book;
import helperclasses.CheckoutRecordEntry;
import helperclasses.TestData;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 * Print to the console the list of book Title – in sorted order -- 
 * in which the book has been checked out on June 27, 2015. 
 * The ordering of the book title is as follows: First sort by the length 
 * of the title (number of characters), then by alphabetical order.  
 */
public class Problem2 {

	public static void main(String[] args) {
		//use this list
		List<CheckoutRecordEntry> list = TestData.INSTANCE.getAllEntries();

//		list.stream().filter(x -> x.getCheckoutDate().equals(LocalDate.of(2015,6,27)))
//					 .map(x -> x.getCopy().getBook().getTitle())
//					 .sorted(Comparator.comparing(String::length))
//					 .sorted()
//					 .collect(Collectors.toList())
//					 .forEach(x -> System.out.println(x));
		
		System.out.println( list.stream().filter(x -> x.getCheckoutDate().equals(LocalDate.of(2015,6,27)))
										 .sorted(Comparator.comparing((CheckoutRecordEntry s) -> s.getCopy().getBook().getTitle().length()).thenComparing((CheckoutRecordEntry s) -> s.getCopy().getBook().getTitle()))
										 .collect(Collectors.toList())
						);
	}
	

}
