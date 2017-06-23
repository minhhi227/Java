package standardExam.prob1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import helperclasses.*;

public class Main {
	
	public static Predicate<CheckoutRecordEntry> isdueDate =x -> x.getDueDate().compareTo(LocalDate.now())<0;
	public static Predicate<CheckoutRecordEntry> isAvaliable =x -> !x.getCopy().isAvailable();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<CheckoutRecord> records = TestData.INSTANCE.getAllRecords();
		List<LibraryMember> mems = TestData.INSTANCE.getMembers();
		
		System.out.println(overdueRecord(records.get(0)));
		System.out.println(memberList(mems));
	}
	public static List<CheckoutRecordEntry> overdueRecord (CheckoutRecord record){
//		return record.getCheckoutRecordEntries().stream()
//														.filter(Main.isdueDate)
//														.filter(Main.isAvaliable)
//														.collect(Collectors.toList());
		return LamdaLibrary.OVERDUDE.apply(record);
	}
	public static boolean isCheckout(BookCopy copy, LibraryMember mem){
		Optional<CheckoutRecordEntry> iscopy = mem.getRecord().getCheckoutRecordEntries().stream()
																					.filter(x -> x.getCopy().equals(copy)).findAny();
	
		if(iscopy.isPresent()) return true;
		else return false;
	}
	public static List<String> memberList(List<LibraryMember> mems){
		return mems.stream().filter(x -> {
			Optional<CheckoutRecordEntry> ischeckout = x.getRecord().getCheckoutRecordEntries().stream().filter(s -> s.getCheckoutDate().compareTo(LocalDate.now())<0).findAny();
			if(ischeckout.isPresent()) return true;
			else return false;
		})
				.map(x -> x.getFirstName() + " " + x.getLastName())
		.collect(Collectors.toList());
	}

}
