package standardExam.prob1;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import helperclasses.*;



public class LamdaLibrary {

	 public static final Function<CheckoutRecord, List<CheckoutRecordEntry>> OVERDUDE 
		= (record) 
		     -> record.getCheckoutRecordEntries().stream()
				.filter(Main.isdueDate)
				.filter(Main.isAvaliable)
				.collect(Collectors.toList());
}
