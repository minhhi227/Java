package standardExam.prob2;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import helperclasses.*;


public class Problem2 {

	//provide a functional interface type for the lambda
		Function<CheckoutRecord, List<CheckoutRecordEntry>> eToString1 = e -> e.getCheckoutRecordEntries();

		//provide a method reference and the type of method reference
		//TYPE: class::instanceMethod
		Function<CheckoutRecord, List<CheckoutRecordEntry>> eToString2 = CheckoutRecord::getCheckoutRecordEntries;

		class MyFunction implements Function<CheckoutRecord, List<CheckoutRecordEntry>> {

			@Override
			public List<CheckoutRecordEntry> apply(CheckoutRecord e) {
				// TODO Auto-generated method stub
				return e.getCheckoutRecordEntries();
			}

		}
		
		
		
		Comparator<Long> empComp1 = (e1, e2) -> e1.compareTo(e2);
		Comparator<Long> empComp2 = Long::compareTo;
		
		 class LongComparator implements Comparator<Long> {
			@Override
			public int compare(Long arg0, Long arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
		}
		 
		 Supplier<Double> random1 = ()-> Math.random();
		 Supplier<Double> random2 = Math::random;
		 
		 class mySupplier implements Supplier<Double> {

			@Override
			public Double get() {
				// TODO Auto-generated method stub
				return Math.random();
			}
		
		}
	
		
}
