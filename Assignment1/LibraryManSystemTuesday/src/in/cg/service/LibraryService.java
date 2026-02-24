package in.cg.service;

import org.springframework.beans.factory.annotation.Autowired;

import in.cg.model.Book;
import in.cg.model.Member;

public class LibraryService {
	private BookService bService;
	private MemberService mService;
	public LibraryService(BookService bService, MemberService mService) {
		super();
		this.bService = bService;
		this.mService = mService;
	}
	public void issueBook(int memberId, int bookId) {

	    Member m = mService.fetchMember(memberId);
	    if (m == null) {
	        System.out.println("Member not found");
	        return;
	    }

	    Book b = bService.fetchBook(bookId);
	    if (b == null) {
	        System.out.println("Book not found");
	        return;
	    }

	    if (!b.isAvailable()) {
	        System.out.println("Book already issued");
	        return;
	    }

	    b.setAvailable(false);
	    System.out.println("Book issued successfully");
	}
	public void returnBook(int memberId, int bookId) {

	    Member m = mService.fetchMember(memberId);
	    if (m == null) {
	        System.out.println("Member not found");
	        return;
	    }

	    Book b = bService.fetchBook(bookId);
	    if (b == null) {
	        System.out.println("Book not found");
	        return;
	    }

	    b.setAvailable(true);
	    System.out.println("Book returned successfully");
	}
}
