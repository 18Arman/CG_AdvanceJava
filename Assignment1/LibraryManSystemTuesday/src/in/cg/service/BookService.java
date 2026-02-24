package in.cg.service;

import in.cg.model.Book;
import in.cg.repository.BookRepository;

public class BookService {

    private BookRepository bRepo;
    private int bookCounter = 4;

    public BookService(BookRepository bRepo) {
        this.bRepo = bRepo;
    }

    public void addBook(String title, String author) {
        Book b = new Book(bookCounter++, title, author, true);
        bRepo.addBook(b);
        System.out.println("Book added successfully");
    }

    public Book fetchBook(int id) {
        return bRepo.getBook(id);
    }

    public void getAvailableBooks() {
        for (Book b : bRepo.getAllBooks()) {
            if (b.isAvailable()) {
                System.out.println(b);
            }
        }
    }
}