package prob3;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import helperclasses.Book;
import helperclasses.BookCopy;
import helperclasses.LibraryMember;
import helperclasses.LibrarySystemException;
import helperclasses.TestData;

public class SampleProblem3 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SampleProblem3 p = new SampleProblem3();
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		p.books = TestData.INSTANCE.getAllBooks().iterator();
		LibraryMember s = p.detectIfWinnerDuringCheckout(members);
		System.out.println(s);
		
	}
	Iterator<Book> books;
	
	public LibraryMember detectIfWinnerDuringCheckout(List<LibraryMember> mems)  {
		//return null;
		//fix this
		return mems.stream().filter(mem -> FunctionWithException.unchecked((LibraryMember s) -> checkLegal(s)).apply(mem))
	    .findFirst().orElse(null);

	}
	
	private boolean checkLegal(LibraryMember mem) throws LibrarySystemException {
		boolean isIllegal = (mem.checkout(books.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1))
		          .getCheckoutRecordEntries().size() == 10);
		if(isIllegal) throw new LibrarySystemException("Illegal Member");
		else return true;
	}
}
