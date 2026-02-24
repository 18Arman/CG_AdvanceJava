package in.cg.repository;

import java.util.List;

import in.cg.model.Book;
import in.cg.service.BookService;

public class BookRepository {
	private List<Book> books;
	public BookRepository(List<Book> books) {
		super();
		this.books = books;
	}
	public void addBook(Book b) {
		books.add(b);
	}
	public List<Book> getAllBooks() {
	    return books;
	}
	public Book getBook(int id) {
		for(Book i:books) {
			if(i.getId()==id) {
				return i;
			}
		}
		return null;
	}
}
